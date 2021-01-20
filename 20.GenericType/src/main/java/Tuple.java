/**
 * @author denglitong
 * @date 2021/1/18
 */
public class Tuple {
    public static <A, B> Tuple2<A, B> tuple2(A a, B b) {
        return new Tuple2<>(a, b);
    }

    public static <A, B, C> Tuple3<A, B, C> tuple3(A a, B b, C c) {
        return new Tuple3<>(a, b, c);
    }

    public static <A, B, C, D> Tuple4<A, B, C, D> tuple4(A a, B b, C c, D d) {
        return new Tuple4<>(a, b, c, d);
    }
}
