import java.io.*;
import java.util.*;

// https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.1
class ClassFile {

  U4 magic;
  U2 minorVersion;
  U2 majorVersion;
  U2 constantPoolCount;
  CpInfo[] constantPool;
  U2 accessFlags;
  U2 thisClass;
  U2 superClass;
  U2 interfacesCount;
  U2[] interfaces;
  U2 fieldsCount;
  FieldInfo[] fields;
  U2 methodsCount;
  MethodInfo[] methods;
  U2 attributesCount;
  AttributeInfo[] attributes;

  public ClassFile(U4 magic,
      U2 minorVersion,
      U2 majorVersion,
      U2 constantPoolCount,
      CpInfo[] constantPool,
      U2 accessFlags,
      U2 thisClass,
      U2 superClass,
      U2 interfacesCount,
      U2[] interfaces,
      U2 fieldsCount,
      FieldInfo[] fields,
      U2 methodsCount,
      MethodInfo[] methods,
      U2 attributesCount,
      AttributeInfo[] attributes) {
    this.magic = magic;
    this.minorVersion = minorVersion;
    this.majorVersion = majorVersion;
    this.constantPoolCount = constantPoolCount;
    this.constantPool = constantPool;
    this.accessFlags = accessFlags;
    this.thisClass = thisClass;
    this.superClass = superClass;
    this.interfacesCount = interfacesCount;
    this.interfaces = interfaces;
    this.fieldsCount = fieldsCount;
    this.fields = fields;
    this.methodsCount = methodsCount;
    this.methods = methods;
    this.attributesCount = attributesCount;
    this.attributes = attributes;
  }
}

// https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4
class CpInfo {

  U1 tag;
  byte[] info;

  public CpInfo(U1 tag, byte[] info) {
    this.info = info;
    this.tag = tag;
  }
}

// https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.5
class FieldInfo {

  U2 accessFlags;
  U2 nameIndex;
  U2 descriptorIndex;
  U2 attributesCount;
  AttributeInfo[] attributes;

  public FieldInfo(U2 accessFlags,
      U2 nameIndex,
      U2 descriptorIndex,
      U2 attributesCount,
      AttributeInfo[] attributes) {
    this.accessFlags = accessFlags;
    this.nameIndex = nameIndex;
    this.descriptorIndex = descriptorIndex;
    this.attributesCount = attributesCount;
    this.attributes = attributes;
  }

    public ConstantValue getConstantValue(ClassFile classFile) {
        ConstantValue constantValue = null;
        final CpInfo[] constantPool = classFile.constantPool;
        for (AttributeInfo attribute : this.attributes) {
            final String attrName = Utils.getUtf8(constantPool, attribute.attributeNameIndex.val);
            if (Objects.equals("ConstantValue", attrName)) {
                final byte[] bytes = attribute.info;
                try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                     final DataInputStream dis = new DataInputStream(bis)
                ) {
                    final int constantValueIndex = dis.readUnsignedShort();
                    constantValue = new ConstantValue(constantValueIndex);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new IllegalStateException("unknown exception");
                }
            }
        }
        return constantValue;
    }
}

// https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.6
class MethodInfo {

  U2 accessFlags;
  U2 nameIndex;
  U2 descriptorIndex;
  U2 attributesCount;
  AttributeInfo[] attributes;

  public MethodInfo(U2 accessFlags,
      U2 nameIndex,
      U2 descriptorIndex,
      U2 attributesCount,
      AttributeInfo[] attributes) {
    this.accessFlags = accessFlags;
    this.nameIndex = nameIndex;
    this.descriptorIndex = descriptorIndex;
    this.attributesCount = attributesCount;
    this.attributes = attributes;
  }

	// 找到属性名为 Code 的进行解析
	public Code getCode(ClassFile classFile) {
		Code code = null;
		final CpInfo[] constantPool = classFile.constantPool;
		for (AttributeInfo attribute : this.attributes) {
		  final String attrName = Utils.getUtf8(constantPool, attribute.attributeNameIndex.val);
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
		return code;
	}

}

// https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.7
class AttributeInfo {

  U2 attributeNameIndex;
  U4 attributeLength;
  byte[] info;

  AttributeInfo(U2 attributeNameIndex, U4 attributeLength, byte[] info) {
    this.attributeNameIndex = attributeNameIndex;
    this.attributeLength = attributeLength;
    this.info = info;
  }
}

// U1, 对应 class file 最小单位，占用空间 8 bit, 实际上就是个 byte.
class U1 {

  public final int val;

  U1(int val) {
    this.val = val;
  }
}

// U2, 两个 byte， 实际上是 无符号 short 类型
class U2 {

  public final int val;

  U2(int val) {
    this.val = val;
  }
}


// U4， 四个 byte, 实际上是无符号 int 类型
class U4 {

  public final int val;

  U4(int val) {
    this.val = val;
  }
}

//class ConstantValue {
//	int constantValueIndex;
//
//	public ConstantValue(int constantValueIndex) {
//		this.constantValueIndex = constantValueIndex;
//	}
//}

/**
class ExceptionTableItem {

  final int startPc;
  final int endPc;
  final int handlerPc;
  final int catchType;

  ExceptionTableItem(int startPc, int endPc, int handlerPc, int catchType) {
    this.startPc = startPc;
    this.endPc = endPc;
    this.handlerPc = handlerPc;
    this.catchType = catchType;
  }
}

class Code {
  int maxStack;
  int maxLocals;
  // the real code
  byte[] bytes;
  ExceptionTableItem[] exceptionTable;
  AttributeInfo[] attributes;

 public Code(int maxStack, int maxLocals, ExceptionTableItem[] exceptionTable, byte[] bytes, AttributeInfo[] attributes) {
    this.maxStack = maxStack;
    this.maxLocals = maxLocals;
    this.exceptionTable = exceptionTable;
    this.bytes = bytes;
    this.attributes = attributes;
  }

  /**
   * 获取方法的字节码指令
   *
   * @return 字节码指令集合
   *
  public Map<Integer, Instruction> getInstructions(CpInfo[] cp) {
    Map<Integer, Instruction> instructionMap = new HashMap<>();
    try (ByteArrayInputStream bis = new ByteArrayInputStream(this.bytes);
        final DataInputStream dis = new DataInputStream(bis)
    ) {
      int pc = 0;
      while (dis.available() > 0) {
        final int opcode = dis.read();
        switch (opcode) {
          case 0x04:
            instructionMap.put(pc, new IConst1Inst());
            pc++;
            break;
          case 0x3b:
            instructionMap.put(pc, new IStore0Inst());
            pc++;
            break;
          case 0x1a:
            instructionMap.put(pc, new ILoad0Inst());
            pc++;
            break;
          case 0xac:
            instructionMap.put(pc, new IReturnInst());
            pc++;
            break;
          case 0x03:
            instructionMap.put(pc, new IConst0Inst());
            pc++;
            break;
          case 0x3c:
            instructionMap.put(pc, new IStore1Inst());
            pc++;
            break;
          case 0x3d:
            instructionMap.put(pc, new IStore2Inst());
            pc++;
            break;
          case 0x1b:
            instructionMap.put(pc, new ILoad1Inst());
            pc++;
            break;
          case 0x1c:
            instructionMap.put(pc, new ILoad2Inst());
            pc++;
            break;
          case 0x60:
            instructionMap.put(pc, new IAddInst());
            pc++;
            break;
          case 0x10:
            instructionMap.put(pc, new BiPushInst(dis.readByte()));
            pc += 2;
            break;
          case 0x84:
            instructionMap.put(pc, new IIncInst(dis.readUnsignedByte(), dis.readByte()));
            pc += 3;
            break;
          case 0xa7:
            instructionMap.put(pc, new GotoInst(dis.readShort()));
            pc += 3;
            break;
          case 0xa3:
            instructionMap.put(pc, new IfICmpGtInst(dis.readShort()));
            pc += 3;
            break;
          case 0xa1:
            instructionMap.put(pc, new IfICmpLtInst(dis.readShort()));
            pc += 3;
            break;
          case 0x64:
            instructionMap.put(pc, new ISubInst());
            pc++;
            break;
         default:
           throw new IllegalStateException("unknown opcode " + opcode);
        }
      }
    } catch (IOException e) {
      throw new IllegalStateException("method code parse failure");
    }

    return instructionMap;
  }

}
*/



