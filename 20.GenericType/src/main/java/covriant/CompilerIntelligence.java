package covriant;

import java.util.Arrays;
import java.util.List;

/**
 * @author denglitong
 * @date 2021/1/19
 */
public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple)flist.get(0);
        // Argument is 'Object'
        System.out.println(flist.contains(new Apple()));
        // Argument is 'Object'
        System.out.println(flist.indexOf(new Apple()));
    }
}
