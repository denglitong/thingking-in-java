import java.lang.reflect.Array;

/**
 * @author denglitong
 * @date 2021/1/19
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        // Class<T> 被传递到构造函数中以从类型擦除中恢复
        // 此时使用 Array.newInstance 生成的数组在运行时是保留了其类型信息的
        array = (T[])Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai =
                new GenericArrayWithTypeToken<>(Integer.class, 10);
        // works now
        Integer[] ia = gai.rep();
    }
}
