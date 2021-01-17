import java.util.stream.Stream;

/**
 * RTFI 依赖于 Class 对象，Class 对象 就用来创建该类所有"常规"实例的
 * 类是程序的一部分，每个类都有一个 Class 对象，被保存在同名的 .class 文件中
 * 为了生成这个类的对象，JVM 先会调用类加载器子系统把这个类加载到内存中
 * 所有的 Class 对象 都属于 Class 类
 * <p>
 * 所有的类都是第一次使用时动态加载到 JVM 中的，
 * 当程序创建第一个对类的静态成员引用的时候触发类加载
 * （构造器是类的静态方法，虽然前面没有显示的 static，
 * 所有使用 new 新建实例的时候触发了对类的静态成员的引用，从而触发类加载）
 * <p>
 * 动态加载使得 Java 具有一些静态语言很难或者根本不可能实现的特性
 * <p>
 * 类加载器首先检查这个类的 Class 对象 是否已经加载，否则根据类名查找 .class 文件
 * 然后对类的字节码验证；一旦类的 Class 对象 被载入内存，它就可以用来创建这个类的所有实例
 * <p>
 * 当使用 .class 来创建对 Class 对象的引用时，不会自动地初始化该 Class 对象
 * 直到第一次引用一个 static 方法或者是非常量的 static 字段，才会进行类初始化
 * （构造器方法是隐式的 static 方法）
 *
 * @author denglitong
 * @date 2021/1/17
 */

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");

    }
    @Override
    public abstract String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}

public class Shapes {
    public static void main(String[] args) {
        // Stream<Shape> 实际上把放入的对象都当作 Object 来持有
        // 只是取元素时会自动转型为 Shape
        // 因此在 Java 中所有类型转换的正确性检查都是在运行时进行的
        Stream.of(new Circle(), new Square(), new Triangle())
                .forEach(Shape::draw);
    }
}
