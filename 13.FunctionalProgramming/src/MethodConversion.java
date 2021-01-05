import java.util.function.BiConsumer;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
class In1 {}
class In2 {}

public class MethodConversion {
    static void accept(In1 in1, In2 in2) {
        System.out.println("accept()");
    }

    static void someOtherName(In1 in1, In2 in2) {
        System.out.println("someOtherName()");
    }

    public static void main(String[] args) {
        BiConsumer<In1, In2> bic;

        bic = MethodConversion::accept;
        bic.accept(new In1(), new In2());

        bic = MethodConversion::someOtherName;
        // can not resolve
        // bic.someOtherName(new In1(), new In2());
        // 在使用函数接口时，名称无关紧要 - 只要函数签名和返回类型相同就行
        // Java8会将方法映射到接口方法
        // 要调用方法，可以调用接口的函数式方法名（accept），而不是你的方法名
        bic.accept(new In1(), new In2());
    }
}
