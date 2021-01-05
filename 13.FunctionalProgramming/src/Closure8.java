import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class Closure8 {
    Supplier<List<Integer>> makeFun() {
        // final修饰对象仅表示不会重新赋值引用，它并不代表不能修改对象本身
        final List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return () -> ai;
    }

    public static void main(String[] args) {
        Closure8 c8 = new Closure8();
        List<Integer> l1 = c8.makeFun().get();
        List<Integer> l2 = c8.makeFun().get();
        System.out.println(l1); // [1]
        System.out.println(l2); // [1]
        // 这种方式依然是安全的，因为每个函数都有自己的ArrayList
        l1.add(42);
        l2.add(96);
        System.out.println(l1); // [1, 42]
        System.out.println(l2); // [1, 96]
    }
}
