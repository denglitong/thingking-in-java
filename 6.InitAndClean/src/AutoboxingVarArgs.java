/**
 * @autor denglitong
 * @date 2019/7/23
 */
public class AutoboxingVarArgs {

    public static void f(Integer... args) {
        for (Integer i : args) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        f(new Integer(1), new Integer(2));
        f(4,5,6,7,8);
        f(10, new Integer(11), new Integer(12));
        // class [I 前导的[表示这是一个数组，后面的I表示数组的类型是基本类型I
        System.out.println("int[]: " + new int[0].getClass());
        // class [Ljava.lang.Integer;
        System.out.println("int[]: " + new Integer[0].getClass());
        // class [Lcom.denglitong.D;
        System.out.println("int[]: " + new D[0].getClass());
    }

}

class D{}
