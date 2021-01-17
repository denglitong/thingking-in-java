package typeinfo.interfacea;

/**
 * @author denglitong
 * @date 2021/1/17
 */
class C implements A {
    @Override
    public void f() {
        System.out.println("public C.f()");
    }

    public void g() {
        System.out.println("public C.g()");
    }

    void u() {
        System.out.println("package C.u()");
    }

    protected void v() {
        System.out.println("protected C.v()");
    }

    private void w() {
        System.out.println("private C.w()");
    }
}

public class HiddenC {
    // C 保持 package 可见性，返回的是 A 类型
    // 由于在包外 C 不可见，虽然返回的 C 对象，
    // 但是你仍然不能使用 A 类型意外的方法
    public static A makeA() {
        return new C();
    }
}
