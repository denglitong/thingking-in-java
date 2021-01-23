import java.util.Arrays;

/**
 * @author denglitong
 * @date 2021/1/23
 */
public class parallelPrefix2 {
    public static void main(String[] args) {
        String[] strings = new Rand.String(1).array(8);
        ArrayShow.show(strings);
        Arrays.parallelPrefix(strings, (a, b) -> a + b);
        ArrayShow.show(strings);
    }
}
