import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author denglitong
 * @date 2021/1/20
 */
public class Apply {
    public static <T, S extends Iterable<T>>
    void apply(S seq, Method f, Object... args) {
        try {
            for (T t : seq) {
                // 反射实现虽然优雅，但是其运行速度通常比非反射要慢
                f.invoke(t, args);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
