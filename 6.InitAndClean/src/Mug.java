/**
 * 非静态实例初始化
 * @autor denglitong
 * @date 2019/7/21
 */
public class Mug {

    Mug(int marker) {
        System.out.println("Mug("+ marker +")");
    }

    void f(int marker) {
        System.out.println("f("+ marker+")");
    }

}

class Mugs {

    Mug mug1;
    Mug mug2;
    // 实例初始化语句，与static的静态初始化一样不过少了static关键字
    // 这种语法可以保证无论调用了哪个显示构造方法这些初始化语句都会发生
    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
    }

    Mugs() {
        System.out.println("Mugs()");
    }

    Mugs(int i) {
        System.out.println("Mugs(int)");
    }

    public static void main(String[] args) {
        System.out.println("Inside main()");
        new Mugs();
        System.out.println("new Mugs() completed");
        new Mugs(1);
        System.out.println("new Mugs(1) completed");

        System.out.println(new Str().s);
    }

}


class Str {

    String s;
    {
        s = "Hello, world";
    }

}
