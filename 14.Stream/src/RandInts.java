import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 终端操作
 * 这些操作获取一个流并产生一个最终结果，他们不会像后端流提供任何东西
 * 因此终端操作总是在管道中做的最后一件事情
 *
 * @autor denglitong
 * @date 2019/9/5
 */
public class RandInts {
    // toArray() 转换成适当类型的数组
    private static int[] rints = new Random(47).
            ints(0, 1000)
            .limit(100)
            .toArray();

    public static IntStream rands() {
        return Arrays.stream(rints);
    }
}
