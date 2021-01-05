import java.util.Optional;
import java.util.stream.Stream;

/**
 * @autor denglitong
 * @date 2019/9/2
 */
public class OptionalBasics {
    static void test(Optional<String> optString) {
        if (optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("Nothing inside!");
        }
    }

    public static void main(String[] args) {
        test(Stream.of("Epithets").findFirst());
        test(Stream.<String>empty().findFirst());
    }
}
