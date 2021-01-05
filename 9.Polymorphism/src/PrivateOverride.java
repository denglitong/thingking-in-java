/**
 * @autor denglitong
 * @date 2019/7/28
 */
public class PrivateOverride {
    // private方法都是隐式Final的，所以不能被覆写
    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derided();
        po.f(); // private f()
    }
}

class Derided extends PrivateOverride {
    // 基类版本中的隐式final的f()屏蔽了派生类中相同函数签名的函数，
    // 因此它都不算是重载方法
    // 为清晰起见，派生类中的方法名采用与基类中 private 方法名不同的命名
    public void f() {
        System.out.println("public f()");
    }
}
