import java.util.ArrayList;

/**
 * @autor denglitong
 * @date 2019/8/6
 */

class Apple {
    private static long counter;
    private final long id = counter++;
    public long id () { return id; }
}

class Orange {}

public class ApplesAndOrangeWithoutGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // // Object default
        // ArrayList apples = new ArrayList();
        // for (int i = 0; i < 3; i++) {
        //     apples.add(new Apple());
        // }
        // // no problem adding an Orange to apples:
        // apples.add(new Orange());
        // for (Object apple : apples) {
        //     System.out.println(((Apple) apple).id());
        //     // Orange is detected only at run time, ClassCastException
        // }

        // diamond syntax <> 棱形语法
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        // compile-time error:
        // apples.add(new Orange());
        for (Apple apple : apples) {
            System.out.println(apple.id());
        }
    }
}
