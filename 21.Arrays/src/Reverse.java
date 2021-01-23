import java.util.Arrays;
import java.util.Collections;

/**
 * @author denglitong
 * @date 2021/1/23
 */
public class Reverse {
    public static void main(String[] args) {
        CompType[] a = new CompType[12];
        Arrays.setAll(a, n -> CompType.get());
        ArrayShow.show("Before sorting", a);

        Arrays.sort(a, Collections.reverseOrder());
        ArrayShow.show("After sorting", a);
    }
}
