import java.util.Arrays;

/**
 * @author denglitong
 * @date 2021/1/22
 */
class Bob {
    final int id;
    public Bob(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Bob" + id;
    }
}

public class SimpleSetAll {
    public static final int SZ = 8;
    static int val = 1;
    static char[] chars = "abcdefghilkmnopqrstuvwxyz".toCharArray();

    static char getChar(int n) {
        return chars[n];
    }

    public static void main(String[] args) {
        int[] ia = new int[SZ];
        long[] la = new long[SZ];
        double[] da = new double[SZ];

        Arrays.setAll(ia, n -> n);
        Arrays.setAll(la, n -> n);
        Arrays.setAll(da, n -> n);
        ArrayShow.show(ia);
        ArrayShow.show(la);
        ArrayShow.show(da);

        Arrays.setAll(ia, n -> val++);
        Arrays.setAll(la, n -> val++);
        Arrays.setAll(da, n -> val++);
        ArrayShow.show(ia);
        ArrayShow.show(la);
        ArrayShow.show(da);

        Bob[] ba = new Bob[SZ];
        // generator: () -> val
        Arrays.setAll(ba, Bob::new);
        ArrayShow.show(ba);

        Character[] ca = new Character[SZ];
        // generator: (index) -> val
        Arrays.setAll(ca, SimpleSetAll::getChar);
        ArrayShow.show(ca);
    }
}
