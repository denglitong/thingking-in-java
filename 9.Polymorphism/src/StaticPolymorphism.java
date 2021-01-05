/**
 * @autor denglitong
 * @date 2019/7/28
 */

class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "Derived staticGet()";
    }

    @Override
    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}

public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub();
        // System.out.println(StaticSuper.staticGet());
        System.out.println(sup.staticGet()); // Base staticGet() 静态方法只与类关联，与单个对象无关
        System.out.println(sup.dynamicGet()); // Derived staticGet()
    }
}
