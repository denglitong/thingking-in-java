import java.util.Arrays;

/**
 * @author denglitong
 * @date 2021/1/23
 */
public class StreamFromArray {
    public static void main(String[] args) {
        String[] s = new Rand.String().array(10);
        Arrays.stream(s)
                .skip(3)
                .limit(5)
                .map(ss -> ss + "!")
                .forEach(System.out::println);

        int[] ia = new Rand.Pint().array(10);
        Arrays.stream(ia)
                .skip(3)
                .limit(5)
                .map(i -> i * 10)
                .forEach(System.out::println);
        Arrays.stream(new int[10]);
        Arrays.stream(new long[10]);
        Arrays.stream(new double[10]);
        // only int, long, double works
        // Arrays.stream(new boolean[10]);
        float[] fa = new Rand.Pfloat().array(10);
        Arrays.stream(ConvertTo.boxed(fa));
        Arrays.stream(new Rand.Float().array(10));
    }
}
