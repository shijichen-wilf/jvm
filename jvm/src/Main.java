import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

// 栈帧
class Frame {

  // 程序计数器，默认值为 0
  public int pc;

  // 本地变量表
  public final Map<Integer, Integer> localVars = new HashMap<>();
  // 操作数栈
  public final Stack<Integer> operandStack = new Stack<>();
}

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
    frame.operandStack.push(1);
    frame.pc += offset();
  }
}

// istore_0
class IStore0Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.localVars.put(0, frame.operandStack.pop());
    frame.pc += offset();
  }
}

// iload_0
class ILoad0Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.operandStack.push(frame.localVars.get(0));
    frame.pc += offset();
  }
}

// ireturn
// 返回指令涉及到栈帧的一些特殊操作，暂时简单实现，输出操作数栈顶的数值
class IReturnInst implements Instruction {

  @Override
  public void eval(Frame frame) {
    System.out.println(frame.operandStack.pop());

    frame.pc += offset();
  }
}

// iconst_0
class IConst0Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.operandStack.push(0);
    frame.pc += offset();
  }
}

// istore_1
class IStore1Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.localVars.put(1, frame.operandStack.pop());
    frame.pc += offset();
  }
}

// istore_2
class IStore2Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.localVars.put(2, frame.operandStack.pop());
    frame.pc += offset();
  }
}

// iload_1
class ILoad1Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.operandStack.push(frame.localVars.get(1));
    frame.pc += offset();
  }
}

// iload_2
class ILoad2Inst implements Instruction {

  @Override
  public void eval(Frame frame) {
    frame.operandStack.push(frame.localVars.get(2));
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
    frame.operandStack.push(val);
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
    int v2 = frame.operandStack.pop();
    int v1 = frame.operandStack.pop();
    if (v1 > v2) {
      frame.pc = offset;
    } else {
      frame.pc += offset();
    }
  }
*/
  @Override
  public void eval(Frame frame) {
    int v2 = frame.operandStack.pop();
    int v1 = frame.operandStack.pop();
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
    int v2 = frame.operandStack.pop();
    int v1 = frame.operandStack.pop();
    if (v1 > v2) {
      frame.pc = offset;
    } else {
      frame.pc += offset();
    }
  }
*/
  @Override
  public void eval(Frame frame) {
    int v2 = frame.operandStack.pop();
    int v1 = frame.operandStack.pop();
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
    int tmp = frame.localVars.get(index);
    tmp += val;
    frame.localVars.put(index, tmp);

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
    int v2 = frame.operandStack.pop();
    int v1 = frame.operandStack.pop();
    frame.operandStack.push(v1 + v2);

    frame.pc += offset();
  }
}

// isub
class ISubInst implements Instruction {

  @Override
  public void eval(Frame frame) {
    int v2 = frame.operandStack.pop();
    int v1 = frame.operandStack.pop();
    frame.operandStack.push(v1 - v2);

    frame.pc += offset();
  }
}


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

public class Main {

	/**
	  *@param file 文件路径，相对路径，绝对路径均可
	  *@return 指令集合
	  */
	/**private static Map<Integer, Instruction> parse(String file) {
	  List<String> rawLines;
	  try {
	    // 获取文件的所有行
	    rawLines = Files.readAllLines(Paths.get(file));
	  } catch (Exception e) {
	    System.out.println("file not found ?");
	    return null;
	  }

	  if (rawLines.isEmpty()) {
	    System.out.println("empty file");
	    return null;
	  }

	  List<String> lines = rawLines.stream()
	    .map(String::trim) // 消除首尾空格
	    .map(it -> it.replaceAll(": ", " ")) // 替换冒号为空格
	    .map(it -> it.replaceAll(", ", " ")) // 替换逗号为空格
	    .map(it -> it.replaceAll(" +", " ")) // 多个空格合并
	    .filter(it -> it.length() > 0)
	    .collect(Collectors.toList());

	  Map<Integer, Instruction> instructionMap = new HashMap<>();
	  for (int i = 0; i < lines.size(); i++) {
	    String raw = lines.get(i);
	    String[] terms = raw.split(" ");
	    int pc = Integer.parseInt(terms[0]);
	    String inst = terms[1];

	    Instruction instruction = null;
	    switch (inst.toLowerCase()) {
	      case "iconst_1":
		instruction = new IConst1Inst();
		break;
	      case "istore_0":
		instruction = new IStore0Inst();
		break;
	      case "iload_0":
		instruction = new ILoad0Inst();
		break;
	      case "ireturn":
		instruction = new IReturnInst();
		break;
	case "iconst_0":
		instruction = new IConst0Inst();
		break;
	case "istore_1":
		instruction = new IStore1Inst();
		break;
	case "istore_2":
		instruction = new IStore2Inst();
		break;
	case "iload_1":
		instruction = new ILoad1Inst();
		break;
	case "iload_2":
		instruction = new ILoad2Inst();
		break;
	case "bipush":
		instruction = new BiPushInst(Byte.parseByte(terms[2]));
		break;
	case "if_icmpgt":
		instruction = new IfICmpGtInst(Integer.parseInt(terms[2]));
		break;
	case "if_icmplt":
		instruction = new IfICmpLtInst(Integer.parseInt(terms[2]));
		break;
	case "iadd":
		instruction = new IAddInst();
		break;
	case "isub":
		instruction = new ISubInst();
		break;
	case "iinc":
		instruction = new IIncInst(Integer.parseInt(terms[2]), Integer.parseInt(terms[3]));
		break;
	case "goto":
		instruction = new GotoInst(Short.parseShort(terms[2]));
		break;
	      default:
		break;
	    }

	    if (instruction == null) {
	      System.out.println("parse file failed. raw : " + raw);
	      return null;
	    }
	    instructionMap.put(pc, instruction);
	  }

	  return instructionMap;
	}
*/
/**
  public static void main(String[] args) {
    // 准备指令集合
    Map<Integer, Instruction> instructionMap = new HashMap<>();
    // 暂时写死四个指令
    instructionMap.put(0, new IConst1Inst());
    instructionMap.put(1, new IStore0Inst());
    instructionMap.put(2, new ILoad0Inst());
    instructionMap.put(3, new IReturnInst());

    // 准备解释
    Frame frame = new Frame();
    Interpreter.run(frame, instructionMap);
  }
	public static void main(String[] args) {
		Map<Integer, Instruction> instructionMap = parse(args[0]);

		Frame frame = new Frame();
		Interpreter.run(frame, instructionMap);
	}

  public static void main(String[] args) throws Exception {
    final java.io.File file = new java.io.File(args[0]);

    ClassFile classFile = null;
    try (java.io.FileInputStream fis = new java.io.FileInputStream(file);
        final java.io.DataInputStream dis = new java.io.DataInputStream(fis)
    ) {
      classFile = ClassReader.read(dis);
    }

    Map<Integer, Instruction> instructionMap = classFile.methods[1].getCode(classFile).getInstructions(classFile.constantPool);
    if (instructionMap != null) {
      Frame frame = new Frame();
      Interpreter.run(frame, instructionMap);
    }
  }
*/
   // 类加载器
  public static void main(String[] args) {
    // 初始化 classpath 为当前目录
    String classpath = ".";
    String mainClass = null;

    // 解析参数, 获取 classpath 和 mainClass
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-cp")) {
        classpath = args[i + 1];
        i++;
        continue;
      }
      if (mainClass == null) {
        mainClass = args[i].replace('.', '/');
      }
    }

    // classpath
    final String home = System.getenv("JAVA_HOME");
    if (home == null) {
      System.out.println("must set JAVA_HOME");
      System.exit(-1);
    }

    // rt.jar path
    final String runtimeJarPath = home + "/jre/lib/rt.jar";
    final boolean exists = new java.io.File(runtimeJarPath).exists();
    if (!exists) {
      System.out.println("not found rt.jar " + runtimeJarPath);
      System.exit(-1);
    }
    // 组装 classpath，并构建 ClassLoader 实例
    classpath = runtimeJarPath + ":" + classpath;
    final ClassLoader loader = new ClassLoader(classpath);
    // 加载主类
    final Class main = loader.findClass(mainClass);
    // 执行主类的第二个方法
    final Method method = main.methods[1];
    final Map<Integer, Instruction> instructions = method.getInstructions();

    if (instructions == null) {
      System.out.println("not found method code instructions");
      System.exit(-1);
    }

    Frame frame = new Frame();
    Interpreter.run(frame, instructions);
 }

}




