import java.util.Arrays;

/**
 * @autor denglitong
 * @date 2019/8/23
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for (T t : ib) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = {"a", "b", "c"};
        // array is not iterable, and no auto up-casting
        // test(strings);
        // you must explicitly convert it to an Iterable
        test(Arrays.asList(strings));
    }
}
