/**
 * findFirst() 无论流是否为并行化的，总是会选择流中的第一个元素
 * findAny() 会选择非并行流中的第一个元素（即使从定义来看是选择任意元素）
 * findAny() 在并行流中可以选择非第一个元素
 * 如果必须选择流中的最后一个元素，那就使用 reduce()
 *
 * @autor denglitong
 * @date 2019/9/7
 */
public class SelectElement {
    public static void main(String[] args) {
        System.out.println(RandInts.rands().findFirst().getAsInt());
        System.out.println(
                RandInts.rands().parallel().findFirst().getAsInt()
        );
        System.out.println(RandInts.rands().findAny().getAsInt());
        System.out.println(
                RandInts.rands().parallel().findAny().getAsInt()
        );
    }
}
