import java.util.stream.Stream;

/**
 * @author litong.deng@foxmail.com
 * @date 2021/5/7
 */
public class FactoryTest {
    public static void test(IFactoryMethod factory) {
        Stream.of("Circle", "Square", "Triangle",
                "Square", "Circle", "Circle", "Triangle")
                .map(factory::create)
                .peek(Shape::draw)
                .peek(Shape::erase)
                // 除非最后使用了一个终结操作，否则 Stream 不会做任何事情
                // 这里 count() 的值被丢弃了，要的是使 Stream 正常触发执行
                .count();
    }
}
