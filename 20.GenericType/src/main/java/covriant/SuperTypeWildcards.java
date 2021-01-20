package covriant;

import java.util.List;

/**
 * https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java
 * <p>
 * PECS
 * Producer Extends, Consumer Super.
 * [extends, super] 界定了范围类型
 *
 * @author denglitong
 * @date 2021/1/19
 */
public class SuperTypeWildcards {
    // super 通配符: 界定下界，保证写进去的至少是类型 T 的超类
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // Error
    }

    // extends 通配符：界定上界，保证读出来的是类型 T
    static void writeTo2(List<? extends Apple> apples) {
        // Required type: capture of ? extends Apple, provided: xxx
        // apples.add(new Apple()); // compile error
        // apples.add(new Jonathan()); // compile error
        // apples.add(new Fruit()); // compile error
        // apples.add(new Object()); // error
        // apples.add(null); // ok
    }
}
