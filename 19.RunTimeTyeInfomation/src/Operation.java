import java.util.function.Supplier;

/**
 * 命令模式（描述、命令）
 *
 * @author denglitong
 * @date 2021/1/17
 */
public class Operation {
    public final Supplier<String> description;
    public final Runnable command;

    public Operation(Supplier<String> description, Runnable command) {
        this.description = description;
        this.command = command;
    }
}
