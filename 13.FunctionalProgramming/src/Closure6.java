import java.util.function.IntSupplier;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class Closure6 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
        final int iFinal = i;
        final int xFinal = x;
        return () -> iFinal + xFinal;
    }
}
