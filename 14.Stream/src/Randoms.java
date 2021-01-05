import java.util.Random;

/**
 * 声明式编程（Declarative Programming）：声明要做什么，而非怎么做
 *
 * @autor denglitong
 * @date 2019/8/25
 */
public class Randoms {
    public static void main(String[] args) {
        // 给Random对象一个种子，以便程序再次运行时产生相同的输出
        // 流式编程才有内部迭代，这是流式编程的核心特征之一
        // 这种机制使得编写代码的可读性增强，也更能利用多核处理器的优势
        // 通过放弃对迭代过程的控制，交给并行化机制
        // 另外，流是懒加载的，只在绝对必要时才计算，可将流看作是"延迟列表"
        new Random(47)
                .ints(5, 20)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);
    }
}
