/**
 * java.util.functional中的接口是有限的，比如有BiFunction但它不能变化为支持三参数函数接口
 * 其实函数式接口的声明比较简单，我们可以自己定义一个：
 *
 * @autor denglitong
 * @date 2019/8/25
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
