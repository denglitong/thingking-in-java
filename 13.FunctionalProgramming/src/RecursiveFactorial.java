/**
 * @autor denglitong
 * @date 2019/8/24
 */
interface IntCall {
    int call(int arg);
}

public class RecursiveFactorial {
    // 递归方法必须是实例变量或静态变量，否则会出现编译时错误
    static IntCall fact;

    public static void main(String[] args) {
        // 整数n的阶乘
        fact = n -> n <= 0 ? 1 : n * fact.call(n - 1);
        for (int i = 0; i <= 10; i++) {
            System.out.println(fact.call(i));
        }
    }
}
