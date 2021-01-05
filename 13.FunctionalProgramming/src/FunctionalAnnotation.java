/**
 * 每个接口只包含一个抽象方法，称为函数式方法
 * 在编写接口时，可以使用 @FunctionalInterface 注解强制执行此"函数式方法"模式
 *
 * @autor denglitong
 * @date 2019/8/24
 */
@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}
/*
@FunctionalInterface
interface NotFunctional {
    String goodbye(String arg);
    String hello(String arg);
}
// multiple non-overriding abstract methods found in interface NotFunctional
*/

public class FunctionalAnnotation {
    public String goodbye(String arg) {
        return "Goodbye, " + arg;
    }

    public String hello(String arg) {
        return "Hello, " + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::goodbye;
        /**
         * 如果将方法引用或Lambda表达式复制给函数式接口（函数签名需要匹配），
         * Java8会适配你的赋值到目标接口
         * 编译器会自动包装方法引用或Lambda表达式到实现接口的类的实例中
         */
        FunctionalNoAnn fna = fa::hello;
        // type Incompatible
        // Functional fac = fa;
        Functional f1 = a -> "Goodbye, " + a;
        FunctionalNoAnn fnal = a -> "Hello, " + a;
    }
}
