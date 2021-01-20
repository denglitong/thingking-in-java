package covriant;

/**
 * @author denglitong
 * @date 2021/1/19
 */
class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}

public class CovariantArrays {
    public static void main(String[] args) {
        // Runtime type is Apple[], not Fruit[] or Orange[]
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple(); // ok
        fruits[1] = new Jonathan(); // ok

        try {
            // java.lang.ArrayStoreException: covriant.Fruit
            // 编译器允许放置一个 Fruit 对象，因为 fruits 保存的是对基类型 Fruit 的引用
            // 但是由于运行期实际类型是 Apple，所以会出现运行时错误
            fruits[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            // java.lang.ArrayStoreException: covriant.Orange
            fruits[0] = new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
