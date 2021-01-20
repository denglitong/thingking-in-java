package problems;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author denglitong
 * @date 2021/1/20
 */
class FixedSizeStack<T> {
    private final int size;
    private Object[] storage;
    private int index = 0;

    public FixedSizeStack(int size) {
        this.size = size;
        storage = new Object[size];
    }

    public void push(T item) {
        if (index < size) {
            storage[index++] = item;
        }
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return index == 0 ? null : (T)storage[--index]; // warning cast
    }

    @SuppressWarnings("unchecked")
    Stream<T> stream() {
        return (Stream<T>)Arrays.stream(storage); // warning cast
    }
}

public class GenericCast {
    static String[] letters = "ABCDEFGHIJKLMNOPQRS".split("");

    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<>(letters.length);
        Arrays.stream(letters)
                .forEach(strings::push);
        System.out.println(strings.pop());
        strings.stream()
                .map(s -> s + " ")
                .forEach(System.out::print);
    }
}
