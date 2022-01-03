import java.io.*;
import java.util.*;
import java.util.zip.*;

class ClassLoader {

  String classpath;

  public ClassLoader(String classpath) {
    this.classpath = classpath;
  }

    /**
   * 从 jar 包中加载 class
   * @param path jar 文件路径
   * @param name 类名
   * @return return null if not found
   */
  ClassFile loadClassFileFromJar(String path, String name) {
    ZipFile file;
    try {
      file = new ZipFile(path);
    } catch (IOException e) {
      throw new IllegalStateException("not found jar file, " + path);
    }

    ZipEntry entry = file.getEntry(name + ".class");
    if (entry == null) {
      return null;
    }

    try (InputStream is = file.getInputStream(entry);
        DataInputStream dis = new DataInputStream(is)) {
      return ClassReader.read(dis);
    } catch (Exception e) {
      e.printStackTrace();
      throw new IllegalStateException("read class failure, " + name);
    }
  }

    /**
   * 从目录加载 class
   * @param path 目录路径，不能以 '/' 结尾，e.g /home/admin/code
   * @param name 类名
   * @return return null if not found.
   */
  ClassFile loadClassFileFromDir(String path, String name) {
     // 如果已到文件所在目录
    if (!name.contains("/")) {
      final File dir = new File(path);
      if (!dir.exists()) {
        return null;
      }
      final String[] files = dir.list();
      if (files == null) {
        return null;
      }

      for (String file : files) {
        // found it
        if (Objects.equals(file, name + ".class")) {
          try (FileInputStream fis = new FileInputStream(new File(path + "/" + name + ".class"));
              DataInputStream dis = new DataInputStream(fis)) {
            return ClassReader.read(dis);
          } catch (Exception e) {
            throw new IllegalStateException("read class failure, " + name);
          }
        }
      }
      return null;
    }

    // 继续下一个目录
    int idx = name.indexOf("/");
    String subDir = name.substring(0, idx);
    String subPath = path + "/" + subDir;
    final String newName = name.substring(idx + 1);
    return loadClassFileFromDir(subPath, newName);
  }

  /**
   * 从 classpath 中加载 class
   * @param classpath e.g temp/test.jar:misc
   * @param name 类名
   * @return return null if not found
   */
  ClassFile loadClassFileFromClasspath(String classpath, String name) {
    ClassFile classFile = null;
    for (String path : classpath.split(":")) {
      // 2.1 jar ?
      if (path.endsWith(".jar")) {
        classFile = loadClassFileFromJar(path, name);
        if (classFile != null) {
          break;
        }
      } else {
        // dir
        classFile = loadClassFileFromDir(path, name);
        if (classFile != null) {
          break;
        }
      }
    }

    if (classFile == null) {
      throw new IllegalStateException("class not found, " + name);
    }
    return classFile;
  }

  /**
   * 从 classpath 加载类。
   * @param name 类名，e.g java/lang/Class
   * @return {@link Class} 实例
   */
  Class findClass(String name) {
    // parse file
    ClassFile classFile = loadClassFileFromClasspath(this.classpath, name);

    // defineClass
    Class clazz = defineClass(classFile);

    // link class
    linkClass(clazz);

    return clazz;
  }

private Class defineClass(ClassFile classFile) {
    final CpInfo[] cp = classFile.constantPool;
    String name = Utils.getClassName(cp, classFile.thisClass.val);
    // check super class 获取类名和父类在常量池的位置
    final int superIdx = classFile.superClass.val;
     // 如果父类不存在，并且类名不是 java/lang/Object，抛出异常
    if (superIdx == 0) {
      if (!Objects.equals("java/lang/Object", name)) {
        throw new IllegalStateException("class has no super " + name);
      }
    }
    Class superClass = null;
    // load super first 如果父类存在，获取父类类名，并且先加载父类（又见递归）
    if (superIdx != 0) {
      final String superClassName = Utils.getClassName(cp, classFile.superClass.val);
      superClass = findClass(superClassName);
    }

    // methods 将 MethodInfo 转换为 Method
    Method[] methods = new Method[classFile.methodsCount.val];
    for (int i = 0; i < methods.length; i++) {
      final MethodInfo methodInfo = classFile.methods[i];
      final int methodAccessFlags = methodInfo.accessFlags.val;
      final String methodName = Utils.getUtf8(cp, methodInfo.nameIndex.val);
      final String methodDescriptor = Utils.getUtf8(cp, methodInfo.descriptorIndex.val);
      // code
      Code code = null;
      for (AttributeInfo attribute : methodInfo.attributes) {
        final String attrName = Utils.getUtf8(cp, attribute.attributeNameIndex.val);
        if (Objects.equals("Code", attrName)) {
          final byte[] bytes = attribute.info;
          try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
              final DataInputStream dis = new DataInputStream(bis)
          ) {
            final int maxStack = dis.readUnsignedShort();
            final int maxLocals = dis.readUnsignedShort();
            final int codeLength = dis.readInt();
            byte[] codeBytes = new byte[codeLength];
            dis.read(codeBytes);

            final int exceptionTableLength = dis.readUnsignedShort();
            // 异常表解析
            final ExceptionTableItem[] exceptionTable = new ExceptionTableItem[exceptionTableLength];
            if (exceptionTableLength > 0) {
              for (int j = 0; j < exceptionTableLength; j++) {
                exceptionTable[j] = new ExceptionTableItem(dis.readUnsignedShort(), dis.readUnsignedShort(),
                    dis.readUnsignedShort(), dis.readUnsignedShort());
              }
            }

            final int attributesCount = dis.readUnsignedShort();
            AttributeInfo[] attributeInfos = new AttributeInfo[attributesCount];
            for (int j = 0; j < attributeInfos.length; j++) {
              int attributeNameIndex = dis.readUnsignedShort();
              int attributeLength = dis.readInt();
              byte[] info = new byte[attributeLength];
              dis.read(info);
              attributeInfos[j] = new AttributeInfo(new U2(attributeNameIndex), new U4(attributeLength), info);
            }

            code = new Code(maxStack, maxLocals, exceptionTable, codeBytes, attributeInfos);
          } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("unknown exception");
          }
        }
      }
      methods[i] = new Method(methodAccessFlags, methodName, methodDescriptor, code);
    }
    // fileds 将 FiledInfo 转换为 FIled
    // TODO

     // 创建实例，并设置状态为 CLASS_LOADED
    final Class clazz = new Class(name, superClass, methods, classFile);
    clazz.stat = Const.CLASS_LOADED;
    return clazz;
}

  private void linkClass(Class clazz) {
    // 优先链接父类
    if (clazz.superClass != null && clazz.superClass.stat < Const.CLASS_LINKED) {
      linkClass(clazz.superClass);
    }

    // verification, 不实现

    // preparation
    // TODO 静态字段的初始化

    // resolution, 不实现
    clazz.stat = Const.CLASS_LINKED;
  }


}

