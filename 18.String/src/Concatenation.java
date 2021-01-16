/**
 * @author denglitong
 * @date 2021/1/14
 */
public class Concatenation {
    public static void main(String[] args) {
        String mango = "mango";
        // 在可优化的情况下，编译器会自动引入 StringBuilder 类来 append，但并非任何时候都是这样
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);
    }
}
