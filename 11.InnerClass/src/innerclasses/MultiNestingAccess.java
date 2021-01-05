package innerclasses;

/**
 * 从多层嵌套类中访问外部类的成员
 *
 * @autor denglitong
 * @date 2019/8/4
 */
class MNA {
    private void f() { System.out.println("MNA f()"); }
    private void c() { System.out.println("MNA c()"); }
    class A {
        private void g() { System.out.println("MNA.A g()"); }
        private void c() { System.out.println("MNA.A c()"); }
        public class B {
            void h() {
                f();
                g();
                c();
                MNA.this.c();
            }
        }
    }
}

public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        // .new 语法能产生正确的作用域，所以不必在调研构造器时限定类名
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
