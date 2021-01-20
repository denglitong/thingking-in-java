import typeinfo.pets.Dog;

import java.util.function.Consumer;

/**
 * @author denglitong
 * @date 2021/1/20
 */
class PerformingDogA extends Dog {
    public void speak() { System.out.println("Woof!"); }
    public void sit() { System.out.println("Sitting"); }
    public void reproduce() {}
}

class RobotA {
    public void speak() { System.out.println("Click!"); }
    public void sit() { System.out.println("Clank!"); }
    public void oilChange() {}
}

class CommunicateA {
    // 这里的泛型 P 没有限定约束，只要可以使用 Consumer<P>
    // 这里 Consumer<P> 代表不带参数的 P 方法的未绑定方法引用
    public static <P>
    void perform(P performer, Consumer<P> action1, Consumer<P> action2) {
        // performer.action1();
        action1.accept(performer);
        action2.accept(performer);
    }
}

public class DogsAndRobotMethodReferences {
    public static void main(String[] args) {
        CommunicateA.perform(new PerformingDogA(),
                PerformingDogA::speak, PerformingDogA::sit);
        CommunicateA.perform(new RobotA(),
                RobotA::speak, RobotA::sit);
        CommunicateA.perform(new Mime(),
                Mime::walkAgainstTheWind,
                Mime::pushInvisibleWalls);
    }
}
