import typeinfo.pets.Dog;

/**
 * @author denglitong
 * @date 2021/1/20
 */
class PerformingDog extends Dog implements Performs {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
    @Override
    public void sit() {
        System.out.println("Sitting");
    }
    public void reproduce() {}
}

class Robot implements Performs {
    @Override
    public void speak() {
        System.out.println("Click!");
    }
    @Override
    public void sit() {
        System.out.println("Clank!");
    }
    public void oilChange() {}
}

class Communicate {
    public static <T extends Performs>
    void perform(T performer) {
        performer.speak();
        performer.sit();
    }

    // 同上，此处不需要使用泛型来工作，可以被简单地指定为一个接口类型
    public static void perform2(Performs performer) {
        performer.speak();
        performer.sit();
    }
}

public class DogsAndRobots {
    public static void main(String[] args) {
        Communicate.perform(new PerformingDog());
        Communicate.perform(new Robot());

        Communicate.perform2(new PerformingDog());
        Communicate.perform2(new Robot());
    }
}
