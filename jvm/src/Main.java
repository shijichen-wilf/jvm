import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

// 栈帧
/**
 * 实验五重构
class Frame {

  // 程序计数器，默认值为 0
  public int pc;

  // 本地变量表
  public final Map<Integer, Integer> localVars = new HashMap<>();
  // 操作数栈
  public final Stack<Integer> operandStack = new Stack<>();
}
*/

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
    Frame frame = new Frame(method.getMaxLocals(), method.getMaxStack());
    Interpreter.run(frame, instructionMap);
  }
	public static void main(String[] args) {
		Map<Integer, Instruction> instructionMap = parse(args[0]);

		Frame frame = new Frame(method.getMaxLocals(), method.getMaxStack());
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
      Frame frame = new Frame(method.getMaxLocals(), method.getMaxStack());
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
    MetaSpace.setClassLoader(loader);
    // 加载主类
    final Class main = loader.findClass(mainClass);
    // 执行主类的第二个方法
    final Method method = main.methods[1];
    final Map<Integer, Instruction> instructions = method.getInstructions();

    if (instructions == null) {
      System.out.println("not found method code instructions");
      System.exit(-1);
    }

    Frame frame = new Frame(method.getMaxLocals(), method.getMaxStack());
    Interpreter.run(frame, instructions);
 }

}




