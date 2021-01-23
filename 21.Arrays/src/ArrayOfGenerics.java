import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author denglitong
 * @date 2021/1/22
 */
public class ArrayOfGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[])la;
        ls[0] = new ArrayList<>();

        // ls[1] = new ArrayList<Integer>();

        Object[] objects = ls;
        objects[1] = new ArrayList<>();

        List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[])new List[10];
        Arrays.setAll(spheres, n -> new ArrayList<>());
    }
}
