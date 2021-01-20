/**
 * 泛型擦除不是一个语言特性，是 Java 为了实现泛型的一种妥协（Java 1.0并不包含泛型）
 * <p>
 * 擦除的主要正当理由是从非泛化代码到泛化代码的转变过程，
 * 以及在不破坏现有类库的情况下将泛型融入到语言中
 * <p>
 * 你需要时刻提醒自己，你只是看起来拥有有关参数的类型信息而已，"不，这只是一个 Object"
 *
 * @author denglitong
 * @date 2021/1/18
 */
public class Manipulator2<T extends HasF> {
    private T obj;

    public Manipulator2(T obj) {
        this.obj = obj;
    }

    public void manipulate() {
        // 调用泛型方法需指定类型边界，使得函数在这个边界里是可找到的
        // 泛型类型参数擦除会擦除到第一个边界（如果没有就退化到 Object）
        obj.f();
    }

    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator2<HasF> manipulator2 = new Manipulator2<>(hf);
        manipulator2.manipulate();

        manipulator2 = new Manipulator2<>(new HasF2());
        manipulator2.manipulate();
    }
}

class HasF2 extends HasF {
    @Override
    public void f() {
        System.out.println("HasF2.f()");
    }
}
