// 指令接口
interface Instruction {

  // offset, 字长， 因为字节码的长度不一致，一般情况下是 1，此处提供默认方法用来获取指定的字长。用来在指令结束时改变栈帧的程序计数器，使之指向下一条指令。
  default int offset() {
    return 1;
  }

  // 具体指令需要实现的方法，是指令自身的业务逻辑。
  void eval(Frame frame);
}

// iconst_1
class IConst1Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.pushInt(1);
    frame.pc += offset();
  }
}

// istore_0
class IStore0Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.setInt(0, frame.popInt());
    frame.pc += offset();
  }
}

// iload_0
class ILoad0Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.pushInt(frame.getInt(0));
    frame.pc += offset();
  }
}

// ireturn
// 返回指令涉及到栈帧的一些特殊操作，暂时简单实现，输出操作数栈顶的数值
class IReturnInst implements Instruction {

  @Override
  public void eval(Frame frame) {
    System.out.println(frame.popInt());

    frame.pc += offset();
  }
}

// iconst_0
class IConst0Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.pushInt(0);
    frame.pc += offset();
  }
}

// istore_1
class IStore1Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.setInt(1, frame.popInt());
    frame.pc += offset();
  }
}

// istore_2
class IStore2Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.setInt(2, frame.popInt());
    frame.pc += offset();
  }
}

// iload_1
class ILoad1Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.pushInt(frame.getInt(1));
    frame.pc += offset();
  }
}

// iload_2
class ILoad2Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.pushInt(frame.getInt(2));
    frame.pc += offset();
  }
}

// bipush
class BiPushInst implements Instruction {

  public final int val;

  public BiPushInst(int val) {
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
}

// if_icmpgt
class IfICmpGtInst implements Instruction {

  public final int offset;

  public IfICmpGtInst(int offset) {
    this.offset = offset;
  }

/**
  @Override
  public void eval(Frame frame) {
    int v2 = frame.popInt();
    int v1 = frame.popInt();
    if (v1 > v2) {
      frame.pc = offset;
    } else {
      frame.pc += offset();
    }
  }
*/
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
}

// if_icmplt
class IfICmpLtInst implements Instruction {

  public final int offset;

  public IfICmpLtInst(int offset) {
    this.offset = offset;
  }

/**
  @Override
  public void eval(Frame frame) {
    int v2 = frame.popInt();
    int v1 = frame.popInt();
    if (v1 > v2) {
      frame.pc = offset;
    } else {
      frame.pc += offset();
    }
  }
*/
  @Override
  public void eval(Frame frame) {
    int v2 = frame.popInt();
    int v1 = frame.popInt();
    if (v1 < v2) {
      frame.pc += offset;
    } else {
      frame.pc += offset();
    }
  }


  @Override
  public int offset() {
    return 3;
  }
}

// goto
class GotoInst implements Instruction {

  public final int offset;

  public GotoInst(int offset) {
    this.offset = offset;
  }

/**  @Override
  public void eval(Frame frame) {
    frame.pc = offset;
  }
*/
  @Override
  public void eval(Frame frame) {
    frame.pc += offset;
  }


  @Override
  public int offset() {
    return 3;
  }
}

// iinc
class IIncInst implements Instruction {

  public final int index;
  public final int val;

  public IIncInst(int index, int val) {
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
}

// iadd
class IAddInst implements Instruction {

  @Override
  public void eval(Frame frame) {
    int v2 = frame.popInt();
    int v1 = frame.popInt();
    frame.pushInt(v1 + v2);

    frame.pc += offset();
  }
}

// isub
class ISubInst implements Instruction {

  @Override
  public void eval(Frame frame) {
    int v2 = frame.popInt();
    int v1 = frame.popInt();
    frame.pushInt(v1 - v2);

    frame.pc += offset();
  }
}

