import java.util.function.Function;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class Curry3Args {
    public static void main(String[] args) {
        Function<String, Function<String, Function<String, String>>>
                sum = a -> b -> c -> a + b + c;

        Function<String, Function<String, String>> hi = sum.apply("Hi ");
        Function<String, String> ho = hi.apply("Ho ");

        System.out.println(ho.apply("Hup"));
        // Hi Ho Hup
    }
}
