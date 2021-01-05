import java.util.stream.Stream;

/**
 * 如果使用Function返回的是数值类型的一种，我们必须使用合适的 mapTo数值类型 进行替代
 *
 * @autor denglitong
 * @date 2019/9/1
 */
public class FunctionMap3 {
    public static void main(String[] args) {
        Stream.of("5", "7", "9")
                .mapToInt(Integer::parseInt)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();

        Stream.of("17", "19", "23")
                .mapToLong(Long::parseLong)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();

        Stream.of("17", "19", "23")
                .mapToDouble(Double::parseDouble)
                .forEach(n -> System.out.format("%f ", n));
        System.out.println();
    }
}
