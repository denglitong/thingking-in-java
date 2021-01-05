import java.util.stream.Stream;

/**
 * @autor denglitong
 * @date 2019/8/29
 */
public class Duplicator {
    public static void main(String[] args) {
        Stream.generate(() -> "duplicate")
                .limit(3)
                .forEach(System.out::println);
    }
}
