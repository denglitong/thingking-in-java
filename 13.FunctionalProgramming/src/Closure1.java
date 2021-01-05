import java.util.function.IntSupplier;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class Closure1 {
    int i;
    // 垃圾回收器几乎肯定会保留一个对象，并将现有的函数以这种方式绑定到该对象上
    // 当然，如果你对同一个对象多次调用makeFun，得到的多个函数将共享i的存储空间
    // 此时可由单例模式来控制只有一个函数？
    IntSupplier makeFun(int x) {
        return () -> x + i++;
    }
}
