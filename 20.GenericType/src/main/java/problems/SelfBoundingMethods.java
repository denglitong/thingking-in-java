package problems;

/**
 * @author denglitong
 * @date 2021/1/20
 */
public class SelfBoundingMethods {
    static <T extends SelfBounded2<T>> T f(T arg) {
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A a = f(new A());
    }
}   
