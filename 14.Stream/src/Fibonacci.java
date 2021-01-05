import java.util.stream.Stream;

/**
 * @autor denglitong
 * @date 2019/8/29
 */
public class Fibonacci {
    int x = 1;

    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        new Fibonacci().numbers()
                .skip(20) // 过滤前20个
                .limit(10) // 然后取10个
                .forEach(System.out::println);
    }
}
