import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @autor denglitong
 * @date 2019/8/18
 */
public class Stack<T> {
    private Deque<T> storage = new ArrayDeque<>();
    public void pust(T v) { storage.push(v); }
    public T peek() { return storage.peek(); }
    public T pop() { return storage.pop(); }
    public boolean isEmpty() { return storage.isEmpty(); }
    @Override
    public String toString() {
        return storage.toString();
    }
}
