/**
 * 代理模式：完成工作的真正类隐藏在代理类的后面，代理类只是反过来调用实现类中的方法
 * 代理模式和桥接模式很相似，代理模式只是桥接模式的一种特殊情况
 *
 * @author litong.deng@foxmail.com
 * @date 2021/5/6
 */
interface ProxyBase {
    void f();
    void g();
    void h();
}

/**
 * 具体实现类鱼代理对象不需要具有相同的接口，只要代理对象以某种方式"代表具体实现的方法调用"即可
 * 然而，拥有一个公共接口是很方便的
 */
class Proxy implements ProxyBase {
    private ProxyBase implementation;

    public Proxy() {
        implementation = new Implementation();
    }

    // pass method call to the implementation:
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
}

class Implementation implements ProxyBase {
    @Override
    public void f() {
        System.out.println("Implementation.f()");
    }

    @Override
    public void g() {
        System.out.println("Implementation.g()");
    }

    @Override
    public void h() {
        System.out.println("Implementation.f()");
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        Proxy p = new Proxy();
        p.f();
        p.g();
        p.h();
    }
}
