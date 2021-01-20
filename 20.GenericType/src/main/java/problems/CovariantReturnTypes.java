package problems;

/**
 * @author denglitong
 * @date 2021/1/20
 */
class Base {}
class Derived extends Base {}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    // 导出类方法能够返回比它覆盖的基类方法更具体的类型
    @Override
    Derived get();
}

class Impl implements DerivedGetter {
    @Override
    public Derived get() {
        return new Derived();
    }
}

public class CovariantReturnTypes {
    static void test(DerivedGetter d) {
        Derived d2 = d.get();
    }

    public static void main(String[] args) {
        test(new Impl());
    }
}
