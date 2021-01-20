/**
 * @author denglitong
 * @date 2021/1/19
 */
public class GenericArray2<T> {
    private Object[] array;

    public GenericArray2(int sz) {
        array = new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        // ok
        return (T)array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep() {
        // 异常：无法破坏基础数组的类型，该基础数组只能是 Object[]
        return (T[])array;
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<>(10);
        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(gai.get(i) + " ");
        }
        System.out.println();

        try {
            Integer[] ia = gai.rep();
        } catch (ClassCastException e) {
            // [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
            System.out.println(e);
        }
    }
}
