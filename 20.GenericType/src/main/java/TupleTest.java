/**
 * @author denglitong
 * @date 2021/1/17
 */
public class TupleTest {
    // 函数多返回值可使用 tuple 元组封装返回
    static Tuple2<String, Integer> f() {
        return new Tuple2<>("hi", 47);
    }

    static Tuple3<Amphibian, String, Integer> g() {
        return new Tuple3<>(new Amphibian(), "hi", 47);
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(g());
    }
}
