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

}

