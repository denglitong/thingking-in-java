import java.util.Arrays;

/**
 * @author denglitong
 * @date 2021/1/23
 */
public class ConvertToTest {
    static final int SIZE = 6;

    public static void main(String[] args) {
        Boolean[] a1 = new Boolean[SIZE];
        Arrays.setAll(a1, new Rand.Boolean()::get);
        boolean[] a1p = ConvertTo.primitive(a1);
        ArrayShow.show("a1p", a1p);
        Boolean[] a1b = ConvertTo.boxed(a1p);
        ArrayShow.show("a1b", a1b);
    }
}
