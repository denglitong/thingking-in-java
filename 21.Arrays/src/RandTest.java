import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author denglitong
 * @date 2021/1/23
 */
public class RandTest {
    static final int SZ = 5;

    public static void main(String[] args) {
        System.out.println("Boolean");
        Boolean[] a1 = new Boolean[SZ];
        Arrays.setAll(a1, new Rand.Boolean()::get);
        ArrayShow.show(a1);

        a1 = Stream.generate(new Rand.Boolean())
                .limit(SZ + 1)
                .toArray(Boolean[]::new);
        ArrayShow.show(a1);
        a1 = new Rand.Boolean().array(SZ + 2);
        ArrayShow.show(a1);
        boolean[] a1b = new Rand.Pboolean().array(SZ + 3);
        ArrayShow.show(a1b);

        System.out.println("Byte");
        Byte[] a2 = new Byte[SZ];
        Arrays.setAll(a2, new Rand.Byte()::get);
        ArrayShow.show(a2);

        a2 = Stream.generate(new Rand.Byte())
                .limit(SZ + 1)
                .toArray(Byte[]::new);
        ArrayShow.show(a2);
        a2 = new Rand.Byte().array(SZ + 2);
        ArrayShow.show(a2);
        byte[] a2b = new Rand.Pbyte().array(SZ + 3);
        ArrayShow.show(a2b);
    }
}
