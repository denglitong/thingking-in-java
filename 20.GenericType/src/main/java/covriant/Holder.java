package covriant;

import java.util.Objects;

/**
 * @author denglitong
 * @date 2021/1/19
 */
public class Holder<T> {
    private T value;

    public Holder() {}

    public Holder(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Holder && Objects.equals(value, ((Holder)obj).value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);
        // Holder<Fruit> fruit = apple; // cannot upcast
        Holder<? extends Fruit> fruit = apple; // ok
        Fruit p = fruit.get();
        d = (Apple)fruit.get();
        try {
            Orange c = (Orange)fruit.get();
        } catch (Exception e) {
            // covriant.Apple cannot be cast to covriant.Orange
            System.out.println(e);
        }

        // fruit.set(new Apple()); // compile error
        // fruit.set(new Fruit()); // compile error
        // false
        System.out.println(fruit.equals(d)); // ok
    }
}
