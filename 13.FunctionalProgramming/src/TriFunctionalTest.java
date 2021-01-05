/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class TriFunctionalTest {
    static int f(int i, long l, double d) { return (int)(i * l * d); }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf = TriFunctionalTest::f;
        System.out.println(tf.apply(1, 2l, 3d));

        tf = (i, l, d) -> (int)((i + l) * d);
        System.out.println(tf.apply(1, 2l, 3d));
    }
}
