// 指令接口
interface Instruction {

  // offset, 字长， 因为字节码的长度不一致，一般情况下是 1，此处提供默认方法用来获取指定的字长。用来在指令结束时改变栈帧的程序计数器，使之指向下一条指令。
  default int offset() {
    return 1;
  }

  // 具体指令需要实现的方法，是指令自身的业务逻辑。
  void eval(Frame frame);
}

class NopInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static NopInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new NopInst();
  }
}

class Aconst_nullInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushRef(null);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Aconst_nullInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Aconst_nullInst();
  }
}

class Iconst_m1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushInt(-1);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Iconst_m1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Iconst_m1Inst();
  }
}

class Iconst_0Inst implements Instruction {
  @Override
public void eval(Frame frame) {
    frame.pushInt(0);
    frame.pc += offset();
  }
 static Iconst_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Iconst_0Inst();
  }

  @Override
  public int offset() {
    return 1;
  }

//  static Iconst_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
 //   throw new IllegalStateException("parse Iconst_0Inst");
 // }
}

class Iconst_1Inst implements Instruction {
 /**
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }
*/
  @Override
  public int offset() {
    return 1;
  }

//  static Iconst_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
//    throw new IllegalStateException("parse Iconst_1Inst");
//  }

  public void eval(Frame frame) {
    frame.pushInt(1);
    frame.pc += offset();
  }

  static Iconst_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Iconst_1Inst();
  }

}

class Iconst_2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushInt(2);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Iconst_2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Iconst_2Inst();
  }
}

class Iconst_3Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushInt(3);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Iconst_3Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Iconst_3Inst();
  }
}

class Iconst_4Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushInt(4);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Iconst_4Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Iconst_4Inst();
  }
}

class Iconst_5Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushInt(5);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Iconst_5Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Iconst_5Inst();
  }
}

class Lconst_0Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushLong(0L);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Lconst_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Lconst_0Inst();
  }
}

class Lconst_1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushLong(1L);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Lconst_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Lconst_1Inst();
  }
}

class Fconst_0Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushFloat(0f);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Fconst_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Fconst_0Inst();
  }
}

class Fconst_1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushFloat(1f);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Fconst_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Fconst_1Inst();
  }
}

class Fconst_2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushFloat(2f);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Fconst_2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Fconst_2Inst();
  }
}

class Dconst_0Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushDouble(0d);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dconst_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Dconst_0Inst();
  }
}

class Dconst_1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushDouble(1d);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dconst_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Dconst_1Inst();
  }
}

class BipushInst implements Instruction {
  public final int val;

  public BipushInst(int val) {
    this.val = val;
  }

  @Override
  public void eval(Frame frame) {
    frame.pushInt(val);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 2;
  }

  static BipushInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
     return new BipushInst(dis.readByte());
  }
}

class SipushInst implements Instruction {
  final int val;
  SipushInst(int val) {
    this.val = val;
  }

  @Override
  public void eval(Frame frame) {
    frame.pushInt(val);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 3;
  }

  static SipushInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new SipushInst(dis.readShort());
  }
}

class LdcInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LdcInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LdcInst");
  }
}

class Ldc_wInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Ldc_wInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Ldc_wInst");
  }
}

class Ldc2_wInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Ldc2_wInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Ldc2_wInst");
  }
}

class IloadInst implements Instruction {
 final int idx;
  IloadInst(int idx) {
    this.idx = idx;
  }

  @Override
  public void eval(Frame frame) {
    frame.pushInt(frame.getInt(idx));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 2;
  }

  static IloadInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IloadInst(dis.readUnsignedByte());
  }
}

class LloadInst implements Instruction {
  final int idx;
  LloadInst(int idx) {
    this.idx = idx;
  }

  @Override
  public void eval(Frame frame) {
    frame.pushLong(frame.getLong(idx));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 2;
  }

  static LloadInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new LloadInst(dis.readUnsignedByte());
  }
}

class FloadInst implements Instruction {
  final int idx;
  FloadInst(int idx) {
    this.idx = idx;
  }

  @Override
  public void eval(Frame frame) {
    frame.pushFloat(frame.getFloat(idx));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 2;
  }

  static FloadInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new FloadInst(dis.readUnsignedByte());
  }
}

class DloadInst implements Instruction {
  final int idx;
  DloadInst(int idx) {
    this.idx = idx;
  }

  @Override
  public void eval(Frame frame) {
    frame.pushDouble(frame.getDouble(idx));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 2;
  }

  static DloadInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new DloadInst(dis.readUnsignedByte());
  }
}

class AloadInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static AloadInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse AloadInst");
  }
}

class Iload_0Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushInt(frame.getInt(0));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Iload_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Iload_0Inst();
  }
}

class Iload_1Inst implements Instruction {
/**  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }
*/
  @Override
  public int offset() {
    return 1;
  }

//  static Iload_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
//    throw new IllegalStateException("parse Iload_1Inst");
//  }

  public void eval(Frame frame) {
    frame.pushInt(frame.getInt(1));
    frame.pc += offset();
  }

  static Iload_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Iload_1Inst();
  }

}

class Iload_2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushInt(frame.getInt(2));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Iload_2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Iload_2Inst();
  }
}

class Iload_3Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushInt(frame.getInt(3));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Iload_3Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Iload_3Inst();
  }
}

class Lload_0Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushLong(frame.getLong(0));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Lload_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Lload_0Inst();
  }
}

class Lload_1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushLong(frame.getLong(1));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Lload_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Lload_1Inst();
  }
}

class Lload_2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushLong(frame.getLong(2));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Lload_2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Lload_2Inst();
  }
}

class Lload_3Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushLong(frame.getLong(3));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Lload_3Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Lload_3Inst();
  }
}

class Fload_0Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushFloat(frame.getFloat(0));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Fload_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Fload_0Inst();
  }
}

class Fload_1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushFloat(frame.getFloat(1));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Fload_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Fload_1Inst();
  }
}

class Fload_2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushFloat(frame.getFloat(2));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Fload_2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Fload_2Inst();
  }
}

class Fload_3Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushFloat(frame.getFloat(3));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Fload_3Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Fload_3Inst();
  }
}

class Dload_0Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushDouble(frame.getDouble(0));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dload_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Dload_0Inst();
  }
}

class Dload_1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushDouble(frame.getDouble(1));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dload_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Dload_1Inst();
  }
}

class Dload_2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushDouble(frame.getDouble(2));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dload_2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Dload_2Inst();
  }
}

class Dload_3Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pushDouble(frame.getDouble(3));
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dload_3Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Dload_3Inst();
  }
}

class Aload_0Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Aload_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Aload_0Inst");
  }
}

class Aload_1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Aload_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Aload_1Inst");
  }
}

class Aload_2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Aload_2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Aload_2Inst");
  }
}

class Aload_3Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Aload_3Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Aload_3Inst");
  }
}

class IaloadInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IaloadInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IaloadInst");
  }
}

class LaloadInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LaloadInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LaloadInst");
  }
}

class FaloadInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static FaloadInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse FaloadInst");
  }
}

class DaloadInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static DaloadInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse DaloadInst");
  }
}

class AaloadInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static AaloadInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse AaloadInst");
  }
}

class BaloadInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static BaloadInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse BaloadInst");
  }
}

class CaloadInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static CaloadInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse CaloadInst");
  }
}

class SaloadInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static SaloadInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse SaloadInst");
  }
}

class IstoreInst implements Instruction {
  final int idx;
  IstoreInst(int idx) {
    this.idx = idx;
  }

  @Override
  public void eval(Frame frame) {
    frame.setInt(idx, frame.popInt());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 2;
  }

  static IstoreInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IstoreInst(dis.readUnsignedByte());
  }
}

class LstoreInst implements Instruction {
  final int idx;
  LstoreInst(int idx) {
    this.idx = idx;
  }

  @Override
  public void eval(Frame frame) {
    frame.setLong(idx, frame.popLong());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 2;
  }

  static LstoreInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new LstoreInst(dis.readUnsignedByte());
  }
}

class FstoreInst implements Instruction {
  final int idx;
  FstoreInst(int idx) {
    this.idx = idx;
  }

  @Override
  public void eval(Frame frame) {
    frame.setFloat(idx, frame.popFloat());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 2;
  }

  static FstoreInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new FstoreInst(dis.readUnsignedByte());
  }
}

class DstoreInst implements Instruction {
  final int idx;
  DstoreInst(int idx) {
    this.idx = idx;
  }

  @Override
  public void eval(Frame frame) {
    frame.setDouble(idx, frame.popDouble());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 2;
  }

  static DstoreInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new DstoreInst(dis.readUnsignedByte());
  }
}

class AstoreInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static AstoreInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse AstoreInst");
  }
}

class Istore_0Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setInt(0, frame.popInt());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Istore_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Istore_0Inst();
  }
}

class Istore_1Inst implements Instruction {
/**  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }
*/
  @Override
  public int offset() {
    return 1;
  }

 // static Istore_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
  //  throw new IllegalStateException("parse Istore_1Inst");
//  }

  public void eval(Frame frame) {
    frame.setInt(1, frame.popInt());
    frame.pc += offset();
  }

  static Istore_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Istore_1Inst();
  }

}

class Istore_2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setInt(2, frame.popInt());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Istore_2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Istore_2Inst();
  }
}

class Istore_3Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setInt(3, frame.popInt());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Istore_3Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Istore_3Inst();
  }
}

class Lstore_0Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setLong(0, frame.popLong());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Lstore_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Lstore_0Inst();
  }
}

class Lstore_1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setLong(1, frame.popLong());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Lstore_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Lstore_1Inst();
  }
}

class Lstore_2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setLong(2, frame.popLong());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Lstore_2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Lstore_2Inst();
  }
}

class Lstore_3Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setLong(3, frame.popLong());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Lstore_3Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Lstore_3Inst();
  }
}

class Fstore_0Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setFloat(0, frame.popFloat());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Fstore_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Fstore_0Inst();
  }
}

class Fstore_1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setFloat(1, frame.popFloat());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Fstore_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Fstore_1Inst();
  }
}

class Fstore_2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setFloat(2, frame.popFloat());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Fstore_2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Fstore_2Inst();
  }
}

class Fstore_3Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setFloat(3, frame.popFloat());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Fstore_3Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Fstore_3Inst();
  }
}

class Dstore_0Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setDouble(0, frame.popDouble());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dstore_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Dstore_0Inst();
  }
}

class Dstore_1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setDouble(1, frame.popDouble());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dstore_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Dstore_1Inst();
  }
}

class Dstore_2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setDouble(2, frame.popDouble());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dstore_2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Dstore_2Inst();
  }
}

class Dstore_3Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.setDouble(3, frame.popDouble());
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dstore_3Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new Dstore_3Inst();
  }
}

class Astore_0Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Astore_0Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Astore_0Inst");
  }
}

class Astore_1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Astore_1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Astore_1Inst");
  }
}

class Astore_2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Astore_2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Astore_2Inst");
  }
}

class Astore_3Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Astore_3Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Astore_3Inst");
  }
}

class IastoreInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IastoreInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IastoreInst");
  }
}

class LastoreInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LastoreInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LastoreInst");
  }
}

class FastoreInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static FastoreInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse FastoreInst");
  }
}

class DastoreInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static DastoreInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse DastoreInst");
  }
}

class AastoreInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static AastoreInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse AastoreInst");
  }
}

class BastoreInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static BastoreInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse BastoreInst");
  }
}

class CastoreInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static CastoreInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse CastoreInst");
  }
}

class SastoreInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static SastoreInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse SastoreInst");
  }
}

class PopInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static PopInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse PopInst");
  }
}

class Pop2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Pop2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Pop2Inst");
  }
}

class DupInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static DupInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse DupInst");
  }
}

class Dup_x1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dup_x1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Dup_x1Inst");
  }
}

class Dup_x2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dup_x2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Dup_x2Inst");
  }
}

class Dup2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dup2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Dup2Inst");
  }
}

class Dup2_x1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dup2_x1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Dup2_x1Inst");
  }
}

class Dup2_x2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Dup2_x2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Dup2_x2Inst");
  }
}

class SwapInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static SwapInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse SwapInst");
  }
}
/**
class IaddInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    int v2 = frame.popInt();
    int v1 = frame.popInt();
    frame.pushInt(v1 + v2);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IaddInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IaddInst();
  }
}

class LaddInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LaddInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LaddInst");
  }
}

class FaddInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static FaddInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse FaddInst");
  }
}

class DaddInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static DaddInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse DaddInst");
  }
}

class IsubInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IsubInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IsubInst");
  }
}

class LsubInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LsubInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LsubInst");
  }
}

class FsubInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static FsubInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse FsubInst");
  }
}

class DsubInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static DsubInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse DsubInst");
  }
}

class ImulInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static ImulInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse ImulInst");
  }
}

class LmulInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LmulInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LmulInst");
  }
}

class FmulInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static FmulInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse FmulInst");
  }
}

class DmulInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static DmulInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse DmulInst");
  }
}

class IdivInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IdivInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IdivInst");
  }
}

class LdivInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LdivInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LdivInst");
  }
}

class FdivInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static FdivInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse FdivInst");
  }
}

class DdivInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static DdivInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse DdivInst");
  }
}

class IremInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IremInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IremInst");
  }
}

class LremInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LremInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LremInst");
  }
}

class FremInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static FremInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse FremInst");
  }
}

class DremInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static DremInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse DremInst");
  }
}

class InegInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static InegInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse InegInst");
  }
}

class LnegInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LnegInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LnegInst");
  }
}

class FnegInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static FnegInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse FnegInst");
  }
}

class DnegInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static DnegInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse DnegInst");
  }
}

class IshlInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IshlInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IshlInst");
  }
}

class LshlInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LshlInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LshlInst");
  }
}

class IshrInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IshrInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IshrInst");
  }
}

class LshrInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LshrInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LshrInst");
  }
}

class IushrInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IushrInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IushrInst");
  }
}

class LushrInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LushrInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LushrInst");
  }
}

class IandInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IandInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IandInst");
  }
}

class LandInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LandInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LandInst");
  }
}

class IorInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IorInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IorInst");
  }
}

class LorInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LorInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LorInst");
  }
}

class IxorInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IxorInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IxorInst");
  }
}

class LxorInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LxorInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LxorInst");
  }
}

class IincInst implements Instruction {
  public final int index;

  public final int val;

  public IincInst(int index, int val) {
    this.index = index;
    this.val = val;
  }

  @Override
  public void eval(Frame frame) {
    int tmp = frame.getInt(index);
    tmp += val;
    frame.setInt(index, tmp);
    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 3;
  }

  static IincInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IincInst(dis.readUnsignedByte(), dis.readByte());
  }
}
*/

class IaddInst implements Instruction {
  public void eval(Frame frame) {
    int v2 = frame.popInt();
    int v1 = frame.popInt();
    frame.pushInt(v1 + v2);
    frame.pc += offset();
  }
  static IaddInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IaddInst();
  }
}

class LaddInst implements Instruction {
  public void eval(Frame frame) {
    final long v2 = frame.popLong();
    final long v1 = frame.popLong();
    frame.pushLong(v1 + v2);
    frame.pc += offset();
  }
  static LaddInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new LaddInst();
  }
}

class FaddInst implements Instruction {
  public void eval(Frame frame) {
    final float v2 = frame.popFloat();
    final float v1 = frame.popFloat();
    frame.pushFloat(v1 + v2);
    frame.pc += offset();
  }
  static FaddInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new FaddInst();
  }
}

class DaddInst implements Instruction {
  public void eval(Frame frame) {
    final double v2 = frame.popDouble();
    final double v1 = frame.popDouble();
    frame.pushDouble(v1 + v2);
    frame.pc += offset();
  }

  static DaddInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new DaddInst();
  }
}

class IsubInst implements Instruction {
  public void eval(Frame frame) {
    final int v2 = frame.popInt();
    final int v1 = frame.popInt();
    frame.pushInt(v1 - v2);
    frame.pc += offset();
  }
  public int offset() {
    return 1;
  }
  static IsubInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IsubInst();
  }
}

class LsubInst implements Instruction {
  public void eval(Frame frame) {
    final long v2 = frame.popLong();
    final long v1 = frame.popLong();
    frame.pushLong(v1 - v2);
    frame.pc += offset();
  }
  static LsubInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new LsubInst();
  }
}

class FsubInst implements Instruction {
  public void eval(Frame frame) {
    final float v2 = frame.popFloat();
    final float v1 = frame.popFloat();
    frame.pushFloat(v1 - v2);
    frame.pc += offset();
  }
  static FsubInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new FsubInst();
  }
}

class DsubInst implements Instruction {
  public void eval(Frame frame) {
    final double v2 = frame.popDouble();
    final double v1 = frame.popDouble();
    frame.pushDouble(v1 - v2);
    frame.pc += offset();
  }
  static DsubInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new DsubInst();
  }
}

class ImulInst implements Instruction {
  public void eval(Frame frame) {
    final int v2 = frame.popInt();
    final int v1 = frame.popInt();
    frame.pushInt(v1 * v2);
    frame.pc += offset();
  }
  static ImulInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new ImulInst();
  }
}

class LmulInst implements Instruction {
  public void eval(Frame frame) {
    final long v2 = frame.popLong();
    final long v1 = frame.popLong();
    frame.pushLong(v1 * v2);
    frame.pc += offset();
  }
  static LmulInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new LmulInst();
  }
}

class FmulInst implements Instruction {
  public void eval(Frame frame) {
    final float v2 = frame.popFloat();
    final float v1 = frame.popFloat();
    frame.pushFloat(v1 * v2);
    frame.pc += offset();
  }
  static FmulInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new FmulInst();
  }
}

class DmulInst implements Instruction {
  public void eval(Frame frame) {
    final double v2 = frame.popDouble();
    final double v1 = frame.popDouble();
    frame.pushDouble(v1 * v2);
    frame.pc += offset();
  }
  static DmulInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new DmulInst();
  }
}

class IdivInst implements Instruction {
  public void eval(Frame frame) {
    final int v2 = frame.popInt();
    final int v1 = frame.popInt();
    frame.pushInt(v1 / v2);
    frame.pc += offset();
  }
  static IdivInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IdivInst();
  }
}

class LdivInst implements Instruction {
  public void eval(Frame frame) {
    final long v2 = frame.popLong();
    final long v1 = frame.popLong();
    frame.pushLong(v1 / v2);
    frame.pc += offset();
  }
  static LdivInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new LdivInst();
  }
}

class FdivInst implements Instruction {
  public void eval(Frame frame) {
    final float v2 = frame.popFloat();
    final float v1 = frame.popFloat();
    frame.pushFloat(v1 / v2);
    frame.pc += offset();
  }
  static FdivInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new FdivInst();
  }
}

class DdivInst implements Instruction {
  public void eval(Frame frame) {
    final double v2 = frame.popDouble();
    final double v1 = frame.popDouble();
    frame.pushDouble(v1 / v2);
    frame.pc += offset();
  }
  static DdivInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new DdivInst();
  }
}

class IremInst implements Instruction {
  public void eval(Frame frame) {
    final int v2 = frame.popInt();
    final int v1 = frame.popInt();
    frame.pushInt(v1 % v2);
    frame.pc += offset();
  }
  static IremInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IremInst();
  }
}

class LremInst implements Instruction {
  public void eval(Frame frame) {
    final long v2 = frame.popLong();
    final long v1 = frame.popLong();
    frame.pushLong(v1 % v2);
    frame.pc += offset();
  }
  static LremInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new LremInst();
  }
}

class FremInst implements Instruction {
  public void eval(Frame frame) {
    final float v2 = frame.popFloat();
    final float v1 = frame.popFloat();
    frame.pushFloat(v1 % v2);
    frame.pc += offset();
  }
  static FremInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new FremInst();
  }
}

class DremInst implements Instruction {
  public void eval(Frame frame) {
    final double v2 = frame.popDouble();
    final double v1 = frame.popDouble();
    frame.pushDouble(v1 % v2);
    frame.pc += offset();
  }
  static DremInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new DremInst();
  }
}

class InegInst implements Instruction {
  public void eval(Frame frame) {
    final int v1 = frame.popInt();
    frame.pushInt(-v1);
    frame.pc += offset();
  }
  static InegInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new InegInst();
  }
}

class LnegInst implements Instruction {
  public void eval(Frame frame) {
    final long v1 = frame.popLong();
    frame.pushLong(-v1);
    frame.pc += offset();
  }
  static LnegInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new LnegInst();
  }
}

class FnegInst implements Instruction {
  public void eval(Frame frame) {
    final float v1 = frame.popFloat();
    frame.pushFloat(-v1);
    frame.pc += offset();
  }
  static FnegInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new FnegInst();
  }
}

class DnegInst implements Instruction {
  public void eval(Frame frame) {
    final double v1 = frame.popDouble();
    frame.pushDouble(-v1);
    frame.pc += offset();
  }
  static DnegInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new DnegInst();
  }
}

class IshlInst implements Instruction {

  public void eval(Frame frame) {
    int v2 = frame.popInt();
    int v1 = frame.popInt();
    int s = v2 & 0x1f;
    int ret = v1 << s;
    frame.pushInt(ret);

    frame.pc += offset();
  }

  public int offset() {
    return 1;
  }

  static IshlInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IshlInst();
  }
}

class LshlInst implements Instruction {

  public void eval(Frame frame) {
    int v2 = frame.popInt();
    long v1 = frame.popLong();
    int s = v2 & 0x1f;
    long ret = v1 << s;
    frame.pushLong(ret);

    frame.pc += offset();
  }

  public int offset() {
    return 1;
  }

  static LshlInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new LshlInst();
  }
}

class IshrInst implements Instruction {

  @Override
  public void eval(Frame frame) {
    int v2 = frame.popInt();
    int v1 = frame.popInt();
    int s = v2 & 0x1f;
    int ret = v1 >> s;
    frame.pushInt(ret);
    frame.pc += offset();
  }

  public int offset() {
    return 1;
  }

  static IshrInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IshrInst();
  }
}

class LshrInst implements Instruction {

  public void eval(Frame frame) {
    final long v2 = frame.popLong();
    final int v1 = frame.popInt();
    frame.pushLong(v1 >> v2);

    frame.pc += offset();
  }

  public int offset() {
    return 1;
  }

  static LshrInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new LshrInst();
  }
}

class IushrInst implements Instruction {

  public void eval(Frame frame) {
    int v2 = frame.popInt();
    int v1 = frame.popInt();
    int s = v2 & 0x1f;

    if (v1 >= 0) {
      int ret = v1 >> s;
      frame.pushInt(ret);
    } else {
      int ret = (v1 >> s) + (2 << ~s);
      frame.pushInt(ret);
    }
    frame.pc += offset();
  }

  public int offset() {
    return 1;
  }

  static IushrInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IushrInst();
  }
}

class LushrInst implements Instruction {
  public void eval(Frame frame) {
    int v2 = frame.popInt();
    long v1 = frame.popLong();
    int s = v2 & 0x3f;

    if (v1 >= 0) {
      long ret = v1 >> s;
      frame.pushLong(ret);
    } else {
      long ret = (v1 >> s) + (2L << ~s);
      frame.pushLong(ret);
    }
    frame.pc += offset();
  }
  public int offset() {
    return 1;
  }
  static LushrInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new LushrInst();
  }
}

class IandInst implements Instruction {
  public void eval(Frame frame) {
    final int v2 = frame.popInt();
    final int v1 = frame.popInt();
    frame.pushInt(v1 & v2);
    frame.pc += offset();
  }
  static IandInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IandInst();
  }
}

class LandInst implements Instruction {
  public void eval(Frame frame) {
    final long v2 = frame.popLong();
    final long v1 = frame.popLong();
    frame.pushLong(v1 & v2);
    frame.pc += offset();
  }
  static LandInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new LandInst();
  }
}

class IorInst implements Instruction {
  public void eval(Frame frame) {
    final int v2 = frame.popInt();
    final int v1 = frame.popInt();
    frame.pushInt(v1 | v2);
    frame.pc += offset();
  }
  static IorInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IorInst();
  }
}

class LorInst implements Instruction {
  public void eval(Frame frame) {
    final long v2 = frame.popLong();
    final long v1 = frame.popLong();
    frame.pushLong(v1 | v2);
    frame.pc += offset();
  }
  static LorInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new LorInst();
  }
}

class IxorInst implements Instruction {
  public void eval(Frame frame) {
    final int v2 = frame.popInt();
    final int v1 = frame.popInt();
    frame.pushInt(v1 ^ v2);
    frame.pc += offset();
  }
  static IxorInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IxorInst();
  }
}

class LxorInst implements Instruction {
  public void eval(Frame frame) {
    final long v2 = frame.popLong();
    final long v1 = frame.popLong();
    frame.pushLong(v1 ^ v2);
    frame.pc += offset();
  }
  static LxorInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new LxorInst();
  }
}

class IincInst implements Instruction {
  public final int index;
  public final int val;
  public IincInst(int index, int val) {
    this.index = index;
    this.val = val;
  }
  public void eval(Frame frame) {
    int tmp = frame.getInt(index);
    tmp += val;
    frame.setInt(index, tmp);
    frame.pc += offset();
  }
  public int offset() {
    return 3;
  }
  static IincInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new IincInst(dis.readUnsignedByte(), dis.readByte());
  }
}

class I2lInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static I2lInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse I2lInst");
  }
}

class I2fInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static I2fInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse I2fInst");
  }
}

class I2dInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static I2dInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse I2dInst");
  }
}

class L2iInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static L2iInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse L2iInst");
  }
}

class L2fInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static L2fInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse L2fInst");
  }
}

class L2dInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static L2dInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse L2dInst");
  }
}

class F2iInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static F2iInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse F2iInst");
  }
}

class F2lInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static F2lInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse F2lInst");
  }
}

class F2dInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static F2dInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse F2dInst");
  }
}

class D2iInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static D2iInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse D2iInst");
  }
}

class D2lInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static D2lInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse D2lInst");
  }
}

class D2fInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static D2fInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse D2fInst");
  }
}

class I2bInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static I2bInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse I2bInst");
  }
}

class I2cInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static I2cInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse I2cInst");
  }
}

class I2sInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static I2sInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse I2sInst");
  }
}

class LcmpInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LcmpInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LcmpInst");
  }
}

class FcmplInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static FcmplInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse FcmplInst");
  }
}

class FcmpgInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static FcmpgInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse FcmpgInst");
  }
}

class DcmplInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static DcmplInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse DcmplInst");
  }
}

class DcmpgInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static DcmpgInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse DcmpgInst");
  }
}

class IfeqInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IfeqInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IfeqInst");
  }
}

class IfneInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IfneInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IfneInst");
  }
}

class IfltInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IfltInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IfltInst");
  }
}

class IfgeInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IfgeInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IfgeInst");
  }
}

class IfgtInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IfgtInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IfgtInst");
  }
}

class IfleInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IfleInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IfleInst");
  }
}

class If_icmpeqInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static If_icmpeqInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse If_icmpeqInst");
  }
}

class If_icmpneInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static If_icmpneInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse If_icmpneInst");
  }
}

class If_icmpltInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static If_icmpltInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse If_icmpltInst");
  }
}

class If_icmpgeInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static If_icmpgeInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse If_icmpgeInst");
  }
}

class If_icmpgtInst implements Instruction {
  public final int offset;

  public If_icmpgtInst(int offset) {
    this.offset = offset;
  }

  @Override
  public void eval(Frame frame) {
    int v2 = frame.popInt();
    int v1 = frame.popInt();
    if (v1 > v2) {
      frame.pc += offset;
    } else {
      frame.pc += offset();
    }
  }

  @Override
  public int offset() {
    return 3;
  }

  static If_icmpgtInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new If_icmpgtInst(dis.readShort());
  }
}

class If_icmpleInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static If_icmpleInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse If_icmpleInst");
  }
}

class If_acmpeqInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static If_acmpeqInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse If_acmpeqInst");
  }
}

class If_acmpneInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static If_acmpneInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse If_acmpneInst");
  }
}

class GotoInst implements Instruction {
   public final int offset;
  public GotoInst(int offset) {
    this.offset = offset;
  }

  @Override
  public void eval(Frame frame) {
    frame.pc += offset;
  }

  @Override
  public int offset() {
    return 3;
  }

  static GotoInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new GotoInst(dis.readShort());
  }
}

class JsrInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static JsrInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse JsrInst");
  }
}

class RetInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static RetInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse RetInst");
  }
}

class TableswitchInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static TableswitchInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse TableswitchInst");
  }
}

class LookupswitchInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LookupswitchInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LookupswitchInst");
  }
}

class IreturnInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IreturnInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IreturnInst");
  }
}

class LreturnInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static LreturnInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse LreturnInst");
  }
}

class FreturnInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static FreturnInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse FreturnInst");
  }
}

class DreturnInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static DreturnInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse DreturnInst");
  }
}

class AreturnInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static AreturnInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse AreturnInst");
  }
}

class ReturnInst implements Instruction {
/**  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }
*/
  @Override
  public int offset() {
    return 1;
  }

 // static ReturnInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
  //  throw new IllegalStateException("parse ReturnInst");
//  }

  public void eval(Frame frame) {
    frame.pc += offset();
  }
  static ReturnInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    return new ReturnInst();
  }

}
/**
class GetstaticInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static GetstaticInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse GetstaticInst");
  }
}
*/
class GetstaticInst implements Instruction {

  final String clazz;
  final String name;
  final String descriptor;

  GetstaticInst(String clazz, String name, String descriptor) {
    this.clazz = clazz;
    this.name = name;
    this.descriptor = descriptor;
  }

  @Override
  public void eval(Frame frame) {
    // TODO real code
    frame.pushRef(null);

    frame.pc += offset();
  }

  @Override
  public int offset() {
    return 3;
  }

  static GetstaticInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    final int gsfi = dis.readUnsignedShort();
    return new GetstaticInst(Utils.getClassNameFromFieldRef(cp, gsfi), Utils.getNameFromFieldRef(cp, gsfi),
        Utils.getDescriptorFromFieldRef(cp, gsfi));
  }
}


class PutstaticInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static PutstaticInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse PutstaticInst");
  }
}

class GetfieldInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static GetfieldInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse GetfieldInst");
  }
}

class PutfieldInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static PutfieldInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse PutfieldInst");
  }
}
/**
class InvokevirtualInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static InvokevirtualInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse InvokevirtualInst");
  }
}
*/

class InvokevirtualInst implements Instruction {

  final String clazz;
  final String name;
  final String descriptor;

  InvokevirtualInst(String clazz, String name, String descriptor) {
    this.clazz = clazz;
    this.name = name;
    this.descriptor = descriptor;
  }

  @Override
    public void eval(Frame frame) {
    if (descriptor.equals("(J)V")) {
      final long val = frame.popLong();
      frame.popRef();
      System.out.println(val);
    } else if (descriptor.equals("(D)V")) {
      final double val = frame.popDouble();
      frame.popRef();
      System.out.println(val);
    } else if (descriptor.equals("(F)V")) {
      final float val = frame.popFloat();
      frame.popRef(); // out
      System.out.println(val);
    } else if (descriptor.equals("(C)V")) {
      final char val = (char) frame.popInt();
      frame.popRef();
      System.out.println(val);
    } else if (descriptor.equals("(Z)V")) {
      final boolean val = frame.popInt() != 0;
      frame.popRef();
      System.out.println(val);
   } else {
      final int val = frame.popInt();
      frame.popRef(); // out
      System.out.println(val);
    }

    frame.pc += offset();
  }


  @Override
  public int offset() {
    return 3;
  }

  static InvokevirtualInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    final int ivi = dis.readUnsignedShort();
    return new InvokevirtualInst(Utils.getClassNameFromMethodRef(cp, ivi), Utils.getNameFromMethodRef(cp, ivi),
        Utils.getDescriptorFromMethodRef(cp, ivi));
  }
}

class InvokespecialInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static InvokespecialInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse InvokespecialInst");
  }
}

class InvokestaticInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static InvokestaticInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse InvokestaticInst");
  }
}

class InvokeinterfaceInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static InvokeinterfaceInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse InvokeinterfaceInst");
  }
}

class InvokedynamicInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static InvokedynamicInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse InvokedynamicInst");
  }
}

class NewInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static NewInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse NewInst");
  }
}

class NewarrayInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static NewarrayInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse NewarrayInst");
  }
}

class AnewarrayInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static AnewarrayInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse AnewarrayInst");
  }
}

class ArraylengthInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static ArraylengthInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse ArraylengthInst");
  }
}

class AthrowInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static AthrowInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse AthrowInst");
  }
}

class CheckcastInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static CheckcastInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse CheckcastInst");
  }
}

class InstanceofInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static InstanceofInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse InstanceofInst");
  }
}

class MonitorenterInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static MonitorenterInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse MonitorenterInst");
  }
}

class MonitorexitInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static MonitorexitInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse MonitorexitInst");
  }
}

class WideInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static WideInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse WideInst");
  }
}

class MultianewarrayInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static MultianewarrayInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse MultianewarrayInst");
  }
}

class IfnullInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IfnullInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IfnullInst");
  }
}

class IfnonnullInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static IfnonnullInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse IfnonnullInst");
  }
}

class Goto_wInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Goto_wInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Goto_wInst");
  }
}

class Jsr_wInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Jsr_wInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Jsr_wInst");
  }
}

class BreakpointInst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static BreakpointInst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse BreakpointInst");
  }
}

class Impdep1Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Impdep1Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Impdep1Inst");
  }
}

class Impdep2Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Impdep2Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Impdep2Inst");
  }
}

class Inst implements Instruction {
  @Override
  public void eval(Frame frame) {
    frame.pc += offset();
    throw new IllegalStateException();
  }

  @Override
  public int offset() {
    return 1;
  }

  static Inst parse(java.io.DataInputStream dis, CpInfo[] cp) throws java.io.IOException {
    throw new IllegalStateException("parse Inst");
  }
}
