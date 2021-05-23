/**
 * FunctionalInterface 注解不是必须的，如果一个接口符合"函数式接口"，那么加不加注解都没有影响
 * 加上该注解能够更好地让编译器进行检查
 *
 * @author litong.deng@foxmail.com
 * @date 2021/5/22
 */
@FunctionalInterface
interface AddValue {
    int apply(int s);
}

class AddThree implements AddValue {
    @Override
    public int apply(int s) {
        return s + 3;
    }
}

public class FunctionInterface {
    public static void test(int v, AddValue adder) {
        System.out.println(adder.apply(v));
    }

    public static void main(String[] args) {
        AddValue adder = new AddThree();
        test(1, adder);

        adder = i -> i + 30;
        test(1, adder);
    }
}
