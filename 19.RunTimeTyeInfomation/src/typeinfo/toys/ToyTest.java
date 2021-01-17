package typeinfo.toys;

/**
 * @author denglitong
 * @date 2021/1/17
 */
interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    Toy() {}
    Toy(int i) {}
}

class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots {
    public FancyToy() {
        super(1);
    }
    void say() {
        System.out.println("This is FancyToy.");
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            // Class.forName 需要使用全限定包名
            c = Class.forName("typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find typeinfo.toys.FancyToy");
            System.exit(1);
        }
        printInfo(c);
        System.out.println("*********");
        for (Class face : c.getInterfaces()) {
            printInfo(face);
            System.out.println("*********");
        }

        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // newInstance() 需要 Class 带有无参参构造器
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }

        printInfo(obj.getClass());
    }
}
