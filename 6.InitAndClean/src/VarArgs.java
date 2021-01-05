/**
 * @autor denglitong
 * @date 2019/7/22
 */
public class VarArgs {

    // static void printArray(Object[] args) {
    static void printArray(Object... args) {
        for (Object obj : args) {
            System.out.println(obj);
        }
    }

    // 可变参数可以不传，则为空数组
    static void f(int required, String... trailing) {
        System.out.println("required: " + required);
        for (String s : trailing) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 对于可变参数显式传递数组是不必要的
        printArray(new Object[]{
                new Integer(47),
                new Float(3.14),
                new Double(11.11),

                new A(),
                new B(),
                new C(),
        });

        printArray(
                new Integer(47),
                new Float(3.14),
                new Double(11.11),

                new A(),
                new B(),
                new C()
        );

        f(1, "one");
        f(2, "two", "three");
        f(3);
    }

}

class A{}
class B{}
class C{}