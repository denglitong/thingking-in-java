import java.util.Random;

/**
 * @author denglitong
 * @date 2021/1/17
 */
class Initable {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        // 不会触发类初始化
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");

        // 立即触发类初始化
        Class initable3 = Class.forName("Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);

        // 编译器常量不触发类初始化（放在了方法区？）
        System.out.println(Initable.STATIC_FINAL);
        // 触发初始化
        System.out.println(Initable.STATIC_FINAL2);
        // 触发初始化
        System.out.println(Initable2.staticNonFinal);

    }
}
