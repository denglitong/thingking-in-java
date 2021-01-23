/**
 * @author denglitong
 * @date 2021/1/22
 */
public class ArrayGenericType<T> {
    T[] array;

    @SuppressWarnings("unchecked")
    public ArrayGenericType(int size) {
        // array = new T[size];
        array = (T[])new Object[size];
    }

    // error: generic array creation
    // public <U> U[] makeArray() { return new U[10]; }
}
