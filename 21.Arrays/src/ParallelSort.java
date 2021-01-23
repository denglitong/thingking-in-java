import org.openjdk.jmh.annotations.*;

import java.util.Arrays;

/**
 * @author denglitong
 * @date 2021/1/23
 */
@State(Scope.Thread)
public class ParallelSort {
    private long[] la;

    @Setup
    public void setup() {
        la = new Rand.Plong().array(100_000);
    }

    @Benchmark
    public void sort() {
        Arrays.sort(la);
    }

    @Benchmark
    public void parallelSort() {
        Arrays.parallelSort(la);
    }
}
