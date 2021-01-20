/**
 * 泛型的核心概念：只需告诉编译器要使用什么类型，剩下的细节交给它来处理
 *
 * @author denglitong
 * @date 2021/1/17
 */
public class GenericHolder<T> {
    private T a;
    public GenericHolder() {}
    public void set(T a) { this.a = a; }
    public T get() { return a; }

    public static void main(String[] args) {
        GenericHolder<Automobile> h3 = new GenericHolder<>();
        h3.set(new Automobile());
        Automobile a = h3.get();
        // h3.set("Not an Automobile"); // compiler error
        // h3.set(1);
    }
}
