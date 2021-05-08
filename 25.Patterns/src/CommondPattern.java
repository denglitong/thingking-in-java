import java.util.Arrays;
import java.util.List;

/**
 * 命令模式：命令模式直观来看就是一个函数对象
 * 我们可以将函数对象作为参数传递给其他方法或对象，来执行特定的操作
 * 命令模式允许我们创建新的行为
 * <p>
 * 利用 Java8 的 lambda 特性，命令模式的实现很简单
 *
 * @author litong.deng@foxmail.com
 * @date 2021/5/7
 */
public class CommondPattern {
    public static void main(String[] args) {
        List<Runnable> macro = Arrays.asList(
                () -> System.out.print("Hello "),
                () -> System.out.print("world! "),
                () -> System.out.println("I'm the command pattern!")
        );
        macro.forEach(Runnable::run);
    }
}
