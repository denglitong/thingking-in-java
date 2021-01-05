import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @autor denglitong
 * @date 2019/9/2
 */
public class Optionals {
    static void basics(Optional<String> optString) {
        if (optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("Nothing inside!");
        }
    }

    static void ifPresent(Optional<String> optString) {
        optString.ifPresent(System.out::println);
    }

    static void orElse(Optional<String> optString) {
        System.out.println(optString.orElse("Nada"));
    }

    static void orElseGet(Optional<String> optString) {
        System.out.println(
                optString.orElseGet(() -> "Generated")
        );
    }

    static void orElseThrow(Optional<String> optString) {
        try {
            System.out.println(optString.orElseThrow(
                    () -> new Exception("Supplied")
            ));
        } catch (Exception e) {
            System.out.println("Caught " + e);
        }
    }

    // 此处Consumer类型，不仅仅是一个消费其他类型的函数的一种类型，而是一种思想
    // 可以接受函数引用，表示该函数的参数符合该消费类型
    // 在test函数中调用accept方法表示将具体参数传递给函数引用
    // 通过传入所以方法都适用的 Consumer 来避免重复代码
    static void test(String testName, Consumer<Optional<String>> cos) {
        System.out.println(" === " + testName + " === ");
        cos.accept(Stream.of("Epithets").findFirst());
        cos.accept(Stream.<String>empty().findFirst());
    }

    public static void main(String[] args) {
        test("basics", Optionals::basics);
        test("ifPresent", Optionals::ifPresent);
        test("orElse", Optionals::orElse);
        test("orElseGet", Optionals::orElseGet);
        test("orElseThrow", Optionals::orElseThrow);
    }
}
