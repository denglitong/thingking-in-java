import java.util.Arrays;
import java.util.Random;

/**
 * @autor denglitong
 * @date 2019/7/22
 */
public class ArraysOfPrimitives {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        a2 = a1;
        for (int i = 0; i < a2.length; i++) {
            a2[i] += 1;
        }
        for (int i = 0; i < a1.length; i++) {
            System.out.println("a1["+ i +"] = " + a1[i]);
        }

        Random random = new Random(47);
        // int[] a = new int[random.nextInt(20)];
        Integer[] a = new Integer[random.nextInt(20)];
        System.out.println("length of a = " + a.length);
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(500); // autoboxing
        }
        System.out.println(Arrays.toString(a));

        Integer[] b = { // 在定义处初始化可以直接用大括号
                new Integer(1), // 显式装箱是不需要的
                2, // 此处的,是可选的
        };

        String[] slice = new String[]{"Hello", " ", "world", "."};
        for (String s : slice) {
            System.out.println(s);
        }

        StrItem[] items = {
                new StrItem("Hello"),
                new StrItem("world"),
        };
    }

}

class StrItem {

    public StrItem(String s) {
        System.out.println(s);
    }

}
