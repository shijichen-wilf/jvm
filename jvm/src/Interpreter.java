import java.util.Map;


// 解释器
class Interpreter {

  /**
   * 解释器运行
   *
   * @param frame 栈帧
   * @param instructions 指令集合
   */
  public static void run(Frame frame, Map<Integer, Instruction> instructions) {
    // 核心循环
    do {
      // 获取指令
      Instruction instruction = instructions.get(frame.pc);
      // 执行指令
      instruction.eval(frame);
    } while (instructions.containsKey(frame.pc));
  }
}

