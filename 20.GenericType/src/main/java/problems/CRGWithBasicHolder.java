package problems;

/**
 * 这里 BasicHolder<T> 会因为类型擦除而只存储 Object
 * 但是在 Subtype extends BasicHolder<Subtype> 其能持有 Subtype 类型信息
 * 从而在 BasicHolder<T> 的 set/get 操作都会返回 T 为 Subtype 的类型信息
 * <p>
 * 这就是 CRG 的本质：基类用导出类代替其参数，意味着泛型基类变成了一种其所有导出类的公共功能的模板
 * 这些功能对于其所有参数和返回值将使用导出类型，也就是说使用确切类型而不是基类型（比如 Object）
 *
 * @author denglitong
 * @date 2021/1/20
 */
class Subtype extends BasicHolder<Subtype> {}

public class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype st1 = new Subtype();
        Subtype st2 = new Subtype();
        st1.set(st2);
        Subtype st3 = st1.get();
        st1.f();
    }
}
