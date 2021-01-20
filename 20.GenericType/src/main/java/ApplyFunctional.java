import java.util.stream.Stream;

/**
 * 充分利用 Java8 的 Stream 流操作，不需要使用 Apply.apply() 方法
 *
 * @author denglitong
 * @date 2021/1/20
 */
public class ApplyFunctional {
    public static void main(String[] args) {
        Stream.of(
                Stream.generate(Shape::new).limit(2),
                Stream.generate(Square::new).limit(2))
                .flatMap(c -> c)// flatten into one stream
                .peek(Shape::rotate)
                .forEach(s -> s.resize(7));

        new FilledList<>(Shape::new, 2)
                .forEach(Shape::rotate);
        new FilledList<>(Square::new, 2)
                .forEach(Shape::rotate);

        SimpleQueue<Shape> shapeQ = Suppliers.fill(
                new SimpleQueue<>(), SimpleQueue::add, Shape::new, 2);
        Suppliers.fill(shapeQ, SimpleQueue::add, Square::new, 2);
        shapeQ.forEach(Shape::rotate);
    }
}
