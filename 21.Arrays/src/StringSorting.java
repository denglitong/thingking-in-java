import java.util.Arrays;
import java.util.Comparator;

/**
 * Java 中的排序算法：原生类型使用快速排序、对象类型的归并排序
 *
 * @author denglitong
 * @date 2021/1/23
 */
public class StringSorting {
    public static void main(String[] args) {
        String[] sa = new Rand.String().array(20);
        ArrayShow.show("Before sorting", sa);
        Arrays.sort(sa);
        ArrayShow.show("After sorting", sa);

        Arrays.sort(sa, Comparator.reverseOrder());
        ArrayShow.show("Revert sorting", sa);

        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        ArrayShow.show("Case-insensitive sorting", sa);
    }
}
