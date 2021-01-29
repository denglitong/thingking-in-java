import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author denglitong
 * @date 2021/1/24
 */

enum Explore {HERE, THERE}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("----- Analying " + enumClass + " -----");
        System.out.println("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        System.out.println("Methods: " + methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.containsAll(Enum)? " +
                exploreMethods.containsAll(enumMethods));
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);
        // OSExecute.command("javap -cp build/classes/main Explore");
        // Compiled from "Reflection.java"
        // final class Explore extends java.lang.Enum<Explore> {
        //     public static final Explore HERE;
        //     public static final Explore THERE;
        //     private static final Explore[] $VALUES;

        // values() 是由编译器添加的 static 方法
        // 另外编译器还给添加了 valueOf() 方法
        //      Enum 类的 valueOf() 有 2 个参数，
        //      编译器添加的这个 valueOf() 方法只有 1 个参数

        //     public static Explore[] values();

        //     public static Explore valueOf(java.lang.String);
        //     private Explore();
        //     static {};
        // }
    }
}
