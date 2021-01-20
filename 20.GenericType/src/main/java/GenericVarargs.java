import java.util.ArrayList;
import java.util.List;

/**
 * @author denglitong
 * @date 2021/1/18
 */
public class GenericVarargs {
    // @SafeVarargs 注解保证我们不会对变长参数列表进行任何修改，消除编译器警告
    @SafeVarargs
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for (T arg : args) {
            result.add(arg);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
        ls = makeList("ABCDEFFHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
    }
}
