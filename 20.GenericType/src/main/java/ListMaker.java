import java.util.ArrayList;
import java.util.List;

/**
 * @author denglitong
 * @date 2021/1/19
 */
public class ListMaker<T> {
    List<T> create() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ListMaker<String> stringMaker = new ListMaker<>();
        List<String> strings = stringMaker.create();
        // []
        System.out.println(strings);
    }
}
