/**
 * 状态模式：状态模式向代理对象添加了更多的实现，
 * 以及在代理对象的生命周期内从一个实现切换到另一种实现的方法。
 * <p>
 * 代理模式和状态模式的区别在于它们解决的问题，代理模式的常见用途如下：
 * 1.远程代理：在不同的地址空间中代理对象，远程方法调用（RMI）编译器会自动为你创建一个远程代理
 * 2.虚拟代理：提供"懒加载"来根据需要创建"昂贵"的对象
 * 3.保护代理：当希望对代理对象有权限访问控制时
 * &nbsp;&nbsp;可将 Java 视为一种保护代理，因为它控制在堆上对象的访问
 * 4.智能引用：要在被代理的对象被访问时添加其他操作
 *
 * @author litong.deng@foxmail.com
 * @date 2021/5/6
 */
interface StateBase {
    void f();
    void g();
    void h();
    void changeImpl(StateBase newImpl);
}

class State implements StateBase {
    private StateBase implementation;

    public State(StateBase impl) {
        implementation = impl;
    }

    @Override
    public void f() {
        implementation.f();
    }

    @Override
    public void g() {
        implementation.g();
    }

    @Override
    public void h() {
        implementation.h();
    }

    @Override
    public void changeImpl(StateBase newImpl) {
        implementation = newImpl;
    }
}

class Implementation1 implements StateBase {
    @Override
    public void f() {
        System.out.println("Implementation1.f()");
    }

    @Override
    public void g() {
        System.out.println("Implementation1.g()");
    }

    @Override
    public void h() {
        System.out.println("Implementation1.h()");
    }

    @Override
    public void changeImpl(StateBase newImpl) {

    }
}

class Implementation2 implements StateBase {
    @Override
    public void f() {
        System.out.println("Implementation2.f()");
    }

    @Override
    public void g() {
        System.out.println("Implementation2.g()");
    }

    @Override
    public void h() {
        System.out.println("Implementation2.h()");
    }

    @Override
    public void changeImpl(StateBase newImpl) {

    }
}

public class StateDemo {
    static void test(StateBase base) {
        base.f();
        base.g();
        base.h();
    }

    public static void main(String[] args) {
        StateBase base = new State(new Implementation1());
        test(base);
        base.changeImpl(new Implementation2());
        test(base);
    }
}
