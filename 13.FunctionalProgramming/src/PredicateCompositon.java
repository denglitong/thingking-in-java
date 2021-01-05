import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class PredicateCompositon {
    static Predicate<String>
            p1 = s -> s.contains("bar"),
            p2 = s -> s.length() < 5,
            p3 = s -> s.contains("foo"),
            p4 = p1.negate().and(p2).or(p3);

    public static void main(String[] args) {
        Stream.of("bar", "foobar", "foobaz", "fongpuckery", "123456")
                .filter(p4)
                .forEach(System.out::println);
    }
}
