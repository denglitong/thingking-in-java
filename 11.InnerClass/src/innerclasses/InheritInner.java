package innerclasses;

/**
 * @autor denglitong
 * @date 2019/8/5
 */
class WithInner {
    class Inner {
        public void f() {
            System.out.println("Inner.f()");
        }
    }
}

/**
 * 继承内部类，但是当要生成一个构造器是，默认的构造器并不能起作用，
 * 而且不能只是传递一个指向外围类对象的引用，此外必须在构造器内使用如下语法：
 * enclosingClassReference.super() 来初始化外围类中的内部类
 */
public class InheritInner extends WithInner.Inner {
    InheritInner(WithInner withInner) {
        withInner.super();
    }

    public static void main(String[] args) {
        WithInner withInner = new WithInner();
        InheritInner ii = new InheritInner(withInner);
        ii.f();
    }
}
