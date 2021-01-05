import java.util.function.IntSupplier;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class AnonymousClosure {
    IntSupplier makeFun(int x) {
        int i = 0;
        // 使用匿名内部类实现函数返回
        // 实际上只要有内部类，就会有闭包
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return x + i;
            }
        };
    }
}
