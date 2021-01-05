/**
 * @autor denglitong
 * @date 2019/7/28
 */
public class PrivateOverride2 {
    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride2 op = new Derived2();
        op.f();
    }
}

class Derived2 extends PrivateOverride2 {
    // 方法不会股改或实现基类型的方法
    // @Override
    public void f() {
        System.out.println("public f()");
    }
}
