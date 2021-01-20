package problems;

/**
 * @author denglitong
 * @date 2021/1/20
 */
interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

interface Getter extends GenericGetter<Getter> {}

class Impl2 implements Getter {
    // 非泛型代码中，参数类型可返回具体子类型
    @Override
    public Impl2 get() {
        return new Impl2();
    }
}

public class GenericAndReturnTypes {
    static void test(Getter g) {
        Getter result = g.get();
        GenericGetter gg = g.get();
        // Impl2 Impl2
        System.out.println(result.getClass().getSimpleName() +
                " " + gg.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        test(new Impl2());
    }
}
