/**
 * @autor denglitong
 * @date 2019/7/21
 */
public class Cup {

    Cup(int marker) {
        System.out.println("Cup("+ marker +")");
    }

    void f(int marker) {
        System.out.println("f("+ marker +")");
    }

}

class Cups {

    static Cup cup1 = new Cup(1);
    static Cup cup2;

    // 静态代码块
    static {
        // cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups()");
    }

}

class ExplicitStatic {

    public static void main(String[] args) {
        System.out.println("Inside main");
        Cups.cup1.f(99);
    }

}
