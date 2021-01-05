import java.util.Arrays;

/**
 * @autor denglitong
 * @date 2019/8/23
 */
public class AdapterMethodIdion {
    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(Arrays.asList(
                "To be or not to be".split(" ")
        ));
        // 正向迭代器
        for (String s : ral) {
            System.out.print(s + " ");
        }
        System.out.println();

        // 反向迭代器（适配器模式提供的）
        for (String s : ral.reversed()) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
