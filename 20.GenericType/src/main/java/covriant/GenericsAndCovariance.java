package covriant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author denglitong
 * @date 2021/1/19
 */
public class GenericsAndCovariance {
    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<>();
        // flist.add(new Apple()); // compile error
        // flist.add(new Fruit()); // compile error
        // flist.add(new Object()); // compile error
        flist.add(null); // ok
        // we know it returns at lease Fruit:
        Fruit f = flist.get(0);
    }
}
