import java.util.stream.Stream;

/**
 * @autor denglitong
 * @date 2019/8/29
 */
public class Bubbles {
    public static void main(String[] args) {
        // 这是创建单独工厂类（Separate Factory class）的另一种方式
        // 在很多方面它更加整洁，但这是一个对于代码组织和品味的问题 -
        // 你总是可以创建一个完全不同的工厂类
        Stream.generate(Bubble::bubbler)
                .limit(5)
                .forEach(System.out::println);
    }
}
