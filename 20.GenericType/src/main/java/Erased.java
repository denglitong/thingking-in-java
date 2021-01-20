/**
 * @author denglitong
 * @date 2021/1/19
 */
public class Erased<T> {
    private final int SIZE = 100;

    public void f(Object arg) {
        // error: illegal generic type for instanceof
        // if (arg instanceof T) {}

        // error: unexped type
        // 部分原因是因为泛型擦除不知道 T 具体类型，部分原因是编译器无法验证 T 是否具有默认无参构造器
        // T var = new T();

        // error: generic array creation
        // T[] array = new T[SIZE];

        // warning: [unchecked] case
        T[] array = (T[])new Object[SIZE];
    }
}
