import java.util.Random;
import java.util.stream.Collectors;

/**
 * StringBuilder 是 Java SE5 引入的，速度快，单线程
 * StringBuffer 是线程安全的，因此开销也会大些
 *
 * @author denglitong
 * @date 2021/1/14
 */
public class UsingStringBuilder {
    public static String string1() {
        Random rand = new Random(47);
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100));
            result.append(", ");
            // 这里会有一个性能陷阱： a + ", " + c 这种拼接编译器会自动引入一个临时 StringBuilder
            // 循环内引入临时变量 StringBuilder 的创建和销毁会变慢
            // result.append(rand.nextInt(100) + ", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }

    public static String string2() {
        String result = new Random(47)
                .ints(25, 0, 100)
                .mapToObj(Integer::toString)
                // Collectors.joining 内部用的也是 StringBuilder 但是不会影响性能
                // 即只会用到一个临时 StringBuilder 而不是循环体内都创建一个
                .collect(Collectors.joining(", "));
        return "[" + result + "]";
    }

    public static void main(String[] args) {
        System.out.println(string1());
        System.out.println(string2());
    }
}
