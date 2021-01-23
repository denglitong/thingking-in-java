import java.util.Arrays;

/**
 * 应该"优先选择集合而不是数组"
 * 只有当证明性能是一个问题时时才应该重构到数组
 *
 * @author denglitong
 * @date 2021/1/23
 */
public class ParallelPrefix1 {
    public static void main(String[] args) {
        int[] nums = new Count.Pint().array(10);
        ArrayShow.show(nums);
        System.out.println(Arrays.stream(nums)
                .reduce(Integer::sum)
                .getAsInt());

        // 正确使用 parallelPrefix() 可能相当复杂
        // 所以通常应该只在存在内存或速度问题时使用
        // 否则，Stream.reduce() 应该是你的首选

        Arrays.parallelPrefix(nums, Integer::sum);
        ArrayShow.show(nums);
        System.out.println(Arrays.stream(new Count.Pint().array(6))
                .reduce(Integer::sum)
                .getAsInt());
    }
}
