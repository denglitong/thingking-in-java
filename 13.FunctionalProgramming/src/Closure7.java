import java.util.function.IntSupplier;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class Closure7 {
    IntSupplier makeFun(int x) {
        Integer i = 0;
        // i = i + 1;
        // 对基本类型和封装类型编译器都能自动识别值是否被修改过
        return () -> i + x;
    }
}
