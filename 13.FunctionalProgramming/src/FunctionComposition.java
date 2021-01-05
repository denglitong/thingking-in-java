import java.util.function.Function;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class FunctionComposition {
    static Function<String, String> f1 = s -> {
        System.out.println(s);
        return s.replace('A', '_');
    };
    static Function<String, String> f2 = s -> s.substring(3);
    static Function<String, String> f3 = s -> s.toLowerCase();
    static Function<String, String> f4 = f1.compose(f2).andThen(f3);

    // static Function<String, String> makeFun(Function<String, String> in) {
    //     // return in.compose(s -> s.substring(3));
    //     // return in.andThen(s -> s.toLowerCase());
    // }

    public static void main(String[] args) {
        System.out.println(f4.apply("GO AFTER ALL AMBULANCES"));
    }
}
