package innerclasses;

/**
 * 只有使用内部类才能实现多重继承
 *
 * @autor denglitong
 * @date 2019/8/4
 */

class D {}

abstract class E {}

class Z extends D {
    E makeE() {
        return new E() {};
    }
}

public class MultiImplementation {
    static void takesD(D d) {}
    static void takesE(E e) {}

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}
