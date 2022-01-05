import java.io.*;
import java.util.*;

class Class {

  ClassFile classFile;
  /**
   * class 状态
   */
  int stat;
  String name;
  Class superClass;
  Method[] methods;

  public Class(String name, Class superClass, Method[] methods, ClassFile classFile) {
    this.name = name;
    this.superClass = superClass;
    this.methods = methods;
    this.classFile = classFile;

    if (this.methods != null) {
      for (Method method : this.methods) {
        method.clazz = this;
      }
    }
  }
}

/**
 * Class Field属性，还存在一些问题
 */
//class Field {
//
//  int accessFlags;
//  String name;
//  String descriptor;
//  ConstantValue constantValue;
//  Class clazz;
//
//  public Field(int accessFlags, String name, String descriptor, ConstantValue constantValue) {
//    this.accessFlags = accessFlags;
//    this.name = name;
//    this.descriptor = descriptor;
//    this.constantValue = constantValue;
//  }
//
//}

class Method {

  int accessFlags;
  String name;
  String descriptor;
  Code code;
  Class clazz;

  public Method(int accessFlags, String name, String descriptor, Code code) {
    this.accessFlags = accessFlags;
    this.name = name;
    this.descriptor = descriptor;
    this.code = code;
  }

  public Map<Integer, Instruction> getInstructions() {
    return this.code.getInstructions(clazz.classFile.constantPool);
  }

  public int getMaxLocals() {
    return this.code.maxLocals;
  }

  public int getMaxStack() {
    return this.code.maxStack;
  }

}

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
   */
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

/**
 * Field ConstantValue类
 */
//class ConstantValue {
//  int constantValueIndex;
//
//  public ConstantValue(int constantValueIndex) {
//    this.constantValueIndex = constantValueIndex;
//  }
//}
