/**
 * @author litong.deng@foxmail.com
 * @date 2021/5/7
 */
public class ShapeFactoryStatic implements IFactoryMethod {
    // 创建工厂的一种方法是显式创建每种类型，也叫静态工厂，
    // 增加新类型时需要修改静态工厂的创建方法
    @Override
    public Shape create(String type) {
        switch (type) {
            case "Circle":
                return new Circle();
            case "Square":
                return new Square();
            case "Triangle":
                return new Triangle();
            default:
                throw new BadShapeCreation(type);
        }
    }

    public static void main(String[] args) {
        FactoryTest.test(new ShapeFactoryStatic());
    }
}
