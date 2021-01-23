import java.util.Arrays;
import java.util.SplittableRandom;

/**
 * 编程设计的一个主要目标是"将易变的元素与稳定的元素分开"
 * 使用策略模式时，变化的代码部分被封装在一个单独的类（策略对象）中
 *
 * @author denglitong
 * @date 2021/1/23
 */
public class CompType implements Comparable<CompType> {
    private static int count = 1;
    private static SplittableRandom r = new SplittableRandom(47);
    int i, j;

    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static CompType get() {
        return new CompType(r.nextInt(100), r.nextInt(100));
    }

    @Override
    public int compareTo(CompType rv) {
        // return (i < rv.i ? -1 : (i == rv.i ? 0 : 1));
        return Integer.compare(i, rv.i);
    }

    @Override
    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if (count++ % 3 == 0) {
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        CompType[] a = new CompType[12];
        Arrays.setAll(a, n -> get());
        ArrayShow.show("Before sorting", a);

        Arrays.sort(a);
        ArrayShow.show("After sorting", a);
    }
}
