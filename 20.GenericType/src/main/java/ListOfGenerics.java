import java.util.ArrayList;
import java.util.List;

/**
 * @author denglitong
 * @date 2021/1/19
 */
public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<>();

    public void add(T item) {
        array.add(item);
    }

    public T get(int index) {
        return array.get(index);
    }
}
