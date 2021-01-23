import java.util.stream.LongStream;

/**
 * @author denglitong
 * @date 2021/1/23
 */
public class CountUpward {
    static long[] fillCounted(int size) {
        return LongStream.iterate(0, i -> i + 1)
                .limit(size)
                .toArray();
    }

    public static void main(String[] args) {
        long[] l1 = fillCounted(20);
        ArrayShow.show(l1);

        // Stream 可以存储将近 1000w 但是之后将会耗尽堆空间
        long[] l2 = fillCounted(10_000_000);
        ArrayShow.show(l2);
    }
}
