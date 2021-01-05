import java.util.function.IntSupplier;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class Closure2 {
    IntSupplier makeFun(int x) {
        // i是局部变量依然可以工作
        // 当makeFun()完成时i就消失
        int i = 0;
        return () -> x + i;
    }
}
