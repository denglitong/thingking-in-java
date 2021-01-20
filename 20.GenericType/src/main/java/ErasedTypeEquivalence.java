import java.util.ArrayList;

/**
 * @author denglitong
 * @date 2021/1/18
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
        // 类型擦除： java.util.ArrayList java.util.ArrayList
        System.out.println(c1.getName() + " " + c2.getName());
    }
}
