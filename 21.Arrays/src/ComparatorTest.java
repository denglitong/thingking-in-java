import java.util.Arrays;
import java.util.Comparator;

/**
 * @author denglitong
 * @date 2021/1/23
 */
class CompTypeComparator implements Comparator<CompType> {
    @Override
    public int compare(CompType o1, CompType o2) {
        return Integer.compare(o1.j, o2.j);
    }
}

public class ComparatorTest {
    public static void main(String[] args) {
        CompType[] a = new CompType[12];
        Arrays.setAll(a, n -> CompType.get());
        ArrayShow.show("Before sorting", a);

        Arrays.sort(a, new CompTypeComparator());
        ArrayShow.show("After sorting", a);
    }
}
