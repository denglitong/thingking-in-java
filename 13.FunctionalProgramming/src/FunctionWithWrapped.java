import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class FunctionWithWrapped {
    public static void main(String[] args) {
        // 使用基本类型可以防止传递参数和返回过程中的自动装箱和自动拆箱，性能更好
        Function<Integer, Double> fid = i -> (double)i;
        // IntToDoubleFunction 接口适配了int->double的转换
        IntToDoubleFunction fid2 = i -> i;
    }
}
