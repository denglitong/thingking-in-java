/**
 * @autor denglitong
 * @date 2019/8/24
 */
class X {
    String f() {
        return "X::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class UnboundMethodReference {
    public static void main(String[] args) {
        // non - static func can not be reference in static context
        // 未绑定的方法引用是指没有关联对象的普通（非静态）方法
        // 使用未绑定的引用之前，我们必须先提供对象：（因为调用方法之前必须得有this这个隐藏变量）
        // MakeString ms = X::f;

        // 要解决未绑定方法引用的赋值问题，我们需要一个对象参数，
        // 如果将未绑定方法的引用赋值给接口，
        // 那么单函数的接口的函数参数不再是和函数方法签名相同的函数，而是对应的一个对象
        // 这是因为你需要一个对象去调用对应的未绑定的方法
        TransformX sp = X::f;
        X x = new X();
        // 这里会以某种方式导致对x.f()的调用
        // Java知道它必须采用第一个参数并在其上调用方法，其实际上就是 this
        System.out.println(sp.transform(x));
        System.out.println(x.f());
    }
}
