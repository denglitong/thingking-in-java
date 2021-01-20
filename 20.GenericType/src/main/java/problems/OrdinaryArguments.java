package problems;

/**
 * @author denglitong
 * @date 2021/1/20
 */
class OrdinarySetter {
    void set(Base base) {
        System.out.println("OrdinarySetter.set(Base)");
    }
}

class DerivedSetter extends OrdinarySetter {
    void set(Derived derived) {
        System.out.println("DerivedSetter.set(Derived)");
    }
}

public class OrdinaryArguments {
    public static void main(String[] args) {
        Base base = new Base();
        Derived derived = new Derived();
        DerivedSetter ds = new DerivedSetter();
        ds.set(derived);
        // 重写函数，没有覆盖重写，因为函数签名不一样（参数类型不一样，即使是有继承关系）
        ds.set(base);
    }
}
