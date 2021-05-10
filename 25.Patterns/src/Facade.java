/**
 * 外观模式：把所有丑陋的东西都隐藏到对象里去
 * 外观模式经常被实现为一个复合单例模式的抽象工厂
 * <p>
 * 包（package）作为外观模式的变体
 * 外观模式更倾向于是过程式（procedural）的，也就是非面向对象的
 * 外观模式关键的一点是隐藏某个库的一部分类（以及它们的交互）
 * 大多数情况下 Java 的 package 功能就足以展示 外观模式
 *
 * @author litong.deng@foxmail.com
 * @date 2021/5/10
 */
class A {
    public A(int x) {
    }
}

class B {
    public B(long x) {
    }
}

class C {
    public C(double x) {
    }
}

public class Facade {
    static A makeA(int x) {
        return new A(x);
    }

    static B makeB(long x) {
        return new B(x);
    }

    static C makeC(double x) {
        return new C(x);
    }

    public static void main(String[] args) {
        // the client programmer gets the objects
        // by calling the static methods:
        A a = Facade.makeA(1);
        B b = Facade.makeB(1);
        C c = Facade.makeC(1.0);
    }
}
