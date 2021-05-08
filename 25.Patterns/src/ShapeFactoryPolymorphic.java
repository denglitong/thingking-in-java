import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 多态工厂：采用工厂模式的原因是可以从基本工厂中继承出不同类型的工厂
 *
 * @author litong.deng@foxmail.com
 * @date 2021/5/7
 */
interface PolymorphicFactory {
    Shape create();
}

class RandomShape implements Supplier<Shape> {
    private final PolymorphicFactory[] factories;
    private Random rand = new Random(42);

    public RandomShape(PolymorphicFactory... factories) {
        this.factories = factories;
    }

    @Override
    public Shape get() {
        return factories[rand.nextInt(factories.length)].create();
    }
}

public class ShapeFactoryPolymorphic {
    public static void main(String[] args) {
        RandomShape rs = new RandomShape(
                Circle::new,
                Shape::new,
                Triangle::new
        );
        Stream.generate(rs)
                .limit(6)
                .peek(Shape::draw)
                .peek(Shape::erase)
                .count();
    }
}
