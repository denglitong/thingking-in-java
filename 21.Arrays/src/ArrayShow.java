import java.util.Arrays;

/**
 * @author denglitong
 * @date 2021/1/21
 */
public interface ArrayShow {
    // 这里的 T 不接受基本类型 int，接受封装类型 Integer
    static <T> void show(T[] a) {
        System.out.println(Arrays.toString(a));
    }

    static void show(boolean[] a) {
        System.out.println(Arrays.toString(a));
    }

    static void show(byte[] a) {
        System.out.println(Arrays.toString(a));
    }

    static void show(char[] a) {
        System.out.println(Arrays.toString(a));
    }

    static void show(short[] a) {
        System.out.println(Arrays.toString(a));
    }

    static void show(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    static void show(long[] a) {
        System.out.println(Arrays.toString(a));
    }

    static void show(float[] a) {
        System.out.println(Arrays.toString(a));
    }

    static void show(double[] a) {
        System.out.println(Arrays.toString(a));
    }

    static <T> void show(String info, T[] a) {
        System.out.print(info + ": ");
        show(a);
    }

    static void show(String info, boolean[] a) {
        System.out.print(info + ": ");
        show(a);
    }

    static void show(String info, byte[] a) {
        System.out.print(info + ": ");
        show(a);
    }

    static void show(String info, char[] a) {
        System.out.print(info + ": ");
        show(a);
    }

    static void show(String info, short[] a) {
        System.out.print(info + ": ");
        show(a);
    }

    static void show(String info, int[] a) {
        System.out.print(info + ": ");
        show(a);
    }

    static void show(String info, long[] a) {
        System.out.print(info + ": ");
        show(a);
    }

    static void show(String info, float[] a) {
        System.out.print(info + ": ");
        show(a);
    }
    
    static void show(String info, double[] a) {
        System.out.print(info + ": ");
        show(a);
    }
}
