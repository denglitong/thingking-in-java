/**
 * @author denglitong
 * @date 2021/1/19
 */
public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            gia = (Generic<Integer>[])new Object[SIZE];
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        gia = new Generic[SIZE];
        // Generic[], erased type:
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>(); // ok
        // gia[1] = new Object(); // compile-time error
    }
}
