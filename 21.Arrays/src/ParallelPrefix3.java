import java.util.Arrays;

/**
 * 使用 Stream 进程初始化很优雅，但是对于大型数组这种方法可能会耗尽堆空间
 * 使用 setAll() 执行初始化更节省内存
 *
 * @author denglitong
 * @date 2021/1/23
 */
public class ParallelPrefix3 {
    static final int SIZE = 10_000_000;

    public static void main(String[] args) {
        long[] nums = new long[SIZE];
        Arrays.setAll(nums, n -> n);
        Arrays.parallelPrefix(nums, Long::sum);

        System.out.println("First 20: " + nums[19]);
        System.out.println("First 200: " + nums[199]);
        System.out.println("All: " + nums[nums.length - 1]);
    }
}
