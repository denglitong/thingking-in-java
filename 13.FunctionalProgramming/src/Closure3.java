import java.util.function.IntSupplier;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class Closure3 {
    IntSupplier makeFun(int x) {
        int i = 0;
        // i++; // 对x或i进行++操作都将报编译错误
        // variables use in lambda should be final or effectively final
        return () -> x + i;
    }
}
