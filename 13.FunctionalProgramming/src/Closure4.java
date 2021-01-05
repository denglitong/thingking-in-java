import java.util.function.IntSupplier;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class Closure4 {
    IntSupplier makeFun(final int x) {
        final int i = 0;
        return () -> i + x;
    }
}
