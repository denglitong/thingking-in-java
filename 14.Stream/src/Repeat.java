import java.util.stream.IntStream;

/**
 * @autor denglitong
 * @date 2019/8/29
 */
public class Repeat {
    public static void repeat(int n, Runnable action) {
        // 用来代替简单的for循环
        IntStream.range(0, n).forEach(i -> action.run());
        // 原则上，在代码中包含并解释 repeat() 并不值得，
        // 诚然它是一个相关透明的工具，但结果取决于你的团队和公司的运作方式
    }
}
