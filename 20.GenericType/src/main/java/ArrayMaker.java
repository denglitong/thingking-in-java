import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author denglitong
 * @date 2021/1/19
 */
public class ArrayMaker<T> {
    // kind 的 具体类型信息会被擦除
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    // 由于泛型擦除此处返回的 T[] 只能是 Object 类型，而这里的 newInstance 会初始化为 null
    @SuppressWarnings("unchecked")
    T[] create(int size) {
        // Array.newInstance 实际上并未包含 kind 的具体类型信息
        return (T[])Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] strings = stringMaker.create(9);
        // [null, null, null, null, null, null, null, null, null]
        System.out.println(Arrays.toString(strings));
    }
}
