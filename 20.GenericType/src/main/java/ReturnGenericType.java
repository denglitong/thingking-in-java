/**
 * @author denglitong
 * @date 2021/1/18
 */
public class ReturnGenericType<T extends HasF> {
    private T obj;

    public ReturnGenericType(T obj) {
        this.obj = obj;
    }

    // 范围限定的泛型在返回的时候是可以返回大限定类型的（即确切的类型）
    public T get() {
        return obj;
    }
}
