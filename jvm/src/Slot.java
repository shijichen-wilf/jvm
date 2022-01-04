/**
 * 数据存储的基本单位
 * 1. 存放一个 32 位的数字
 * 2. 存放一个对象引用
 */
public class Slot {

    // 基本类型
    public final int val;
    // 引用类型
    public final Instance ref;

    private Slot(int val, Instance ref) {
        this.val = val;
        this.ref = ref;
    }

    public static Slot val(int val) {
        return new Slot(val, null);
    }

    public static Slot ref(Instance ref) {
        return new Slot(0, ref);
    }
}

/**
 * 实例，虚拟机内部产生的所有对象实例
 */
class Instance {
    // TODO, 后续实现对象相关的指令时会涉及到。
}
