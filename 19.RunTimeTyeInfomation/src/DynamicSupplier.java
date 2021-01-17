import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author denglitong
 * @date 2021/1/17
 */
class CountedInteger {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}

public class DynamicSupplier<T> implements Supplier<T> {
    private Class<T> type;

    public DynamicSupplier(Class<T> type) {
        this.type = type;
    }

    @Override
    public T get() {
        try {
            // 需要该类型有一个无参构造器否则抛异常，返回 Class<T> 指定的 T 的实例，而不只是 Object
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Stream.generate(new DynamicSupplier<>(CountedInteger.class))
                .skip(10)
                .limit(5)
                .forEach(System.out::println);
    }
}
