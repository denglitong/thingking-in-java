import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态工厂：在添加新类型时无需修改任何内容
 * 使用反射在首次需要时将类型的构造器动态加载到工厂列表中
 *
 * @author litong.deng@foxmail.com
 * @date 2021/5/7
 */
public class ShapeFactoryDynamic implements IFactoryMethod {
    Map<String, Constructor> factories = new HashMap<>();

    static Constructor load(String id) {
        System.out.println("loading " + id);
        try {
            // 这里 id 还需要加上全限定包名，这里没有包，所以前面为空
            return Class.forName(id).getConstructor();
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new BadShapeCreation(id);
        }
    }

    @Override
    public Shape create(String type) {
        try {
            return (Shape)factories.computeIfAbsent(type, ShapeFactoryDynamic::load)
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException |
                InvocationTargetException e) {
            throw new BadShapeCreation(type);
        }
    }

    public static void main(String[] args) {
        FactoryTest.test(new ShapeFactoryDynamic());
    }
}
