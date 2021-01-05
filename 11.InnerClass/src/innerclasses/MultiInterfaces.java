package innerclasses;

/**
 * @autor denglitong
 * @date 2019/8/4
 */
interface A {}

interface B {}

/**
 * 使用单一类实现两个接口
 */
class X implements A, B {}

/**
 * 使用内部类实现2个接口
 */
class Y implements A {
    B makeB() {
        // anonymous inner class
        return new B() {};
    }
}

/**
 * 通常两种方式下的代码结构都有逻辑意义，但遇到问题的时候，通常问题本身就能给出某些指引告诉我们应该使用单一类还是内部类
 * 但是如果拥有的是抽象的类或具体的类而不是接口，那就只能使用内部类才能实现多重继承
 */
public class MultiInterfaces {
    static void takesA(A a) {}
    static void takesB(B b) {}

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
    }
}
