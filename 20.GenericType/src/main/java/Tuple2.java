/**
 * 元组
 *
 * @author denglitong
 * @date 2021/1/17
 */
public class Tuple2<A, B> {
    // final 确保创建后就不能修改
    public final A a1;
    public final B a2;

    public Tuple2(A a1, B a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    public String rep() {
        return a1 + ", " + a2;
    }

    @Override
    public String toString() {
        return "(" + rep() + ")";
    }
}
