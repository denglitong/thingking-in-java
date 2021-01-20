import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author denglitong
 * @date 2021/1/20
 */
class Mime {
    public void walkAgainstTheWind() {
        System.out.println("Walking against the wind");
    }
    public void sit() {
        System.out.println("Pretending to sit");
    }
    public void pushInvisibleWalls() {
        System.out.println("Yest I do!");
    }
    @Override
    public String toString() {
        return "Mime";
    }
}

class SmartDog {
    public void speak() {
        System.out.println("Woof!");
    }
    public void sit() {
        System.out.println("Sitting");
    }
    public void reproduce() {}
}

/**
 * 使用反射来弥补 Java 中没有像 Python/C++/Go 那样的潜在泛型类型
 */
class CommunicateReflectively {
    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + " cannot speak");
            }
            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + " cannot sit");
            }
        } catch (SecurityException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException(speaker.toString(), e);
        }
    }
}

public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());
    }
}
