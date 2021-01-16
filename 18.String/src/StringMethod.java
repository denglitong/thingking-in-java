/**
 * @author denglitong
 * @date 2021/1/14
 */
public class StringMethod {
    public static void main(String[] args) {
        System.out.println("hello".toCharArray());
        System.out.println("hello".regionMatches(2, "llinux", 0, 2));
        System.out.println("hello".substring(2));
        System.out.println("hello".substring(2, 4));
        System.out.println("hello".subSequence(0, 3));
        System.out.println("hello".intern());
        System.out.println(String.format("%2s", "hello"));
    }
}
