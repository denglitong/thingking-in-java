package problems;

/**
 * 如果不使用自限定，将重载参数类型
 * 如果使用了自限定，只能获得方法的一个版本，它将接受确切的参数类型
 *
 * @author denglitong
 * @date 2021/1/20
 */
interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {}

class Impl3<T extends SelfBoundSetter<T>> implements SelfBoundSetter<T> {
    @Override
    public void set(T arg) {

    }
}

class Impl4 implements Setter {
    @Override
    public void set(Setter arg) {

    }
}

public class SelfBoundingAndCovariantArguments {
    static void test(Setter s1, Setter s2, SelfBoundSetter sbs) {
        s1.set(s2);
        // s1.set(sbs);
    }

    public static void main(String[] args) {
        test(new Impl4(), new Impl4(), new Impl3());
    }
}
