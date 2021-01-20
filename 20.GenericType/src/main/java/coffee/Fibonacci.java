package coffee;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Java 泛型约束：基本类型无法作为类型参数
 *
 * @author denglitong
 * @date 2021/1/18
 */
public class Fibonacci implements Supplier<Integer> {
    private int count = 0;

    @Override
    public Integer get() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Stream.generate(new Fibonacci())
                .limit(18)
                .map(n -> n + " ")
                .forEach(System.out::print);
    }
}
