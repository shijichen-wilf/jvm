public class Utils {

  public static String getUtf8(CpInfo[] cp, int utf8Idx) {
    final CpInfo utf8 = cp[utf8Idx];
    if (utf8.tag.val != Const.CONSTANT_Utf8) {
      throw new IllegalStateException("unexpect tag");
    }

    return new String(utf8.info);
  }

  /**
   * 从常量池中获取 类名
   */
  public static String getClassName(CpInfo[] cp, int classIdx) {
    final CpInfo classInfo = cp[classIdx];
    if (classInfo.tag.val != Const.CONSTANT_Class) {
      throw new IllegalStateException("un expect tag");
    }

    final byte[] info = classInfo.info;
    final int nameIndex = (info[0] << 8) + (info[1] & 0xff);
    return getUtf8(cp, nameIndex);
  }

  /**
   * 从常量池 NameAndType 项中获取 Name.
   */
  public static String getNameFromNameAndType(CpInfo[] cp, int idx) {
    final CpInfo item = cp[idx];
    if (item.tag.val != Const.CONSTANT_NameAndType) {
      throw new IllegalStateException("un expect tag");
    }
    final byte[] info = item.info;
    final int uidx = (info[0] << 8) + (info[1] & 0xff);
    return getUtf8(cp, uidx);
  }

  /**
   * 从常量池 NameAndType 项中获取 type.
   */
  public static String getDescriptorFromNameAndType(CpInfo[] cp, int idx) {
    final CpInfo item = cp[idx];
    if (item.tag.val != Const.CONSTANT_NameAndType) {
      throw new IllegalStateException("un expect tag");
    }
    final byte[] info = item.info;
    final int uidx = (info[2] << 8) | (info[3] & 0xff);
    return getUtf8(cp, uidx);
  }

  /**
   * 从常量池 FiledRef 中获取 类名
   */
  public static String getClassNameFromFieldRef(CpInfo[] cp, int fieldRefIdx) {
    final CpInfo item = cp[fieldRefIdx];
    if (item.tag.val != Const.CONSTANT_Fieldref) {
      throw new IllegalStateException("un expect tag");
    }

    final byte[] info = item.info;
    final int clzIdx = (info[0] << 8) + (info[1] & 0xff);
    return getClassName(cp, clzIdx);
  }

  /**
   * 从常量池 FiledRef 中获取 字段名
   */
  public static String getNameFromFieldRef(CpInfo[] cp, int fieldRefIdx) {
    final CpInfo item = cp[fieldRefIdx];
    if (item.tag.val != Const.CONSTANT_Fieldref) {
      throw new IllegalStateException("un expect tag");
    }

    final byte[] info = item.info;
    final int nameIndex = (info[2] << 8) | (info[3] & 0xff);
    return getNameFromNameAndType(cp, nameIndex);
  }

  /**
   * 从常量池 FiledRef 中获取 字段描述符
   */
  public static String getDescriptorFromFieldRef(CpInfo[] cp, int fieldRefIdx) {
    final CpInfo item = cp[fieldRefIdx];
    if (item.tag.val != Const.CONSTANT_Fieldref) {
      throw new IllegalStateException("un expect tag");
    }

    final byte[] info = item.info;
    final int idx = (info[2] << 8) | (info[3] & 0xff);
    return getDescriptorFromNameAndType(cp, idx);
  }


  /**
   * 从常量池 MethodRef 中获取 类名
   */
  public static String getClassNameFromMethodRef(CpInfo[] cp, int refIdx) {
    final CpInfo item = cp[refIdx];
    if (item.tag.val != Const.CONSTANT_Methodref) {
      throw new IllegalStateException("un expect tag");
    }

    final byte[] info = item.info;
    final int clzIdx = (info[0] << 8) + (info[1] & 0xff);
    return getClassName(cp, clzIdx);
  }

  /**
   * 从常量池 MethodRef 中获取 方法名
   */
  public static String getNameFromMethodRef(CpInfo[] cp, int refIdx) {
    final CpInfo item = cp[refIdx];
    if (item.tag.val != Const.CONSTANT_Methodref) {
      throw new IllegalStateException("un expect tag");
    }

    final byte[] info = item.info;
    final int nameIndex = (info[2] << 8) | (info[3] & 0xff);
    return getNameFromNameAndType(cp, nameIndex);
  }

  /**
   * 从常量池 MethodRef 中获取 方法描述符
   */
  public static String getDescriptorFromMethodRef(CpInfo[] cp, int refIdx) {
    final CpInfo item = cp[refIdx];
    if (item.tag.val != Const.CONSTANT_Methodref) {
      throw new IllegalStateException("un expect tag");
    }

    final byte[] info = item.info;
    final int idx = (info[2] << 8) | (info[3] & 0xff);
    return getDescriptorFromNameAndType(cp, idx);
  }

  /**
   * 判定访问标志是否是 static
   */
  public static boolean isStatic(int accessFlags) {
    return (accessFlags & Const.ACC_STATIC) != 0;
  }

}

