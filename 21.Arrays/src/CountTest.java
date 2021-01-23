import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author denglitong
 * @date 2021/1/22
 */
public class CountTest {
    static final int SZ = 5;

    public static void main(String[] args) {
        System.out.println("Boolean");
        Boolean[] a1 = new Boolean[SZ];
        Arrays.setAll(a1, new Count.Boolean()::get);
        ArrayShow.show(a1);

        a1 = Stream.generate(new Count.Boolean())
                .limit(SZ + 1)
                .toArray(Boolean[]::new);
        ArrayShow.show(a1);
        a1 = new Count.Boolean().array(SZ + 2);
        ArrayShow.show(a1);
        boolean[] a1b = new Count.Pboolean().array(SZ + 3);
        ArrayShow.show(a1b);

        System.out.println("Byte");
        Byte[] a2 = new Byte[SZ];
        Arrays.setAll(a2, new Count.Byte()::get);
        ArrayShow.show(a2);

        a2 = Stream.generate(new Count.Byte())
                .limit(SZ + 1)
                .toArray(Byte[]::new);
        ArrayShow.show(a2);
        a2 = new Count.Byte().array(SZ + 2);
        ArrayShow.show(a2);
        byte[] a2b = new Count.Pbyte().array(SZ + 3);
        ArrayShow.show(a2b);

        System.out.println("Character");
        Character[] a3 = new Character[SZ];
        Arrays.setAll(a3, new Count.Character()::get);
        ArrayShow.show(a3);

        a3 = Stream.generate(new Count.Character())
                .limit(SZ + 1)
                .toArray(Character[]::new);
        ArrayShow.show(a3);
        a3 = new Count.Character().array(SZ + 1);
        ArrayShow.show(a3);
        char[] a3b = new Count.Pchar().array(SZ + 2);
        ArrayShow.show(a3b);

        System.out.println("Short");
        Short[] a4 = new Short[SZ];
        Arrays.setAll(a4, new Count.Short()::get);
        ArrayShow.show(a4);

        a4 = Stream.generate(new Count.Short())
                .limit(SZ + 1)
                .toArray(Short[]::new);
        ArrayShow.show(a4);
        a4 = new Count.Short().array(SZ + 2);
        ArrayShow.show(a4);
        short[] a4b = new Count.Pshort().array(SZ + 3);
        ArrayShow.show(a4b);

        System.out.println("Integer");
        Integer[] a5 = new Integer[SZ];
        Arrays.setAll(a5, new Count.Integer()::get);
        ArrayShow.show(a5);

        a5 = Stream.generate(new Count.Integer())
                .limit(SZ + 1)
                .toArray(Integer[]::new);
        ArrayShow.show(a5);
        a5 = new Count.Integer().array(SZ + 2);
        ArrayShow.show(a5);
        int[] a5b = new Count.Pint().array(SZ + 3);
        ArrayShow.show(a5b);

        System.out.println("Long");
        Long[] a6 = new Long[SZ];
        Arrays.setAll(a6, new Count.Long()::get);
        ArrayShow.show(a6);

        a6 = Stream.generate(new Count.Long())
                .limit(SZ + 1)
                .toArray(Long[]::new);
        ArrayShow.show(a6);
        a6 = new Count.Long().array(SZ + 2);
        ArrayShow.show(a6);
        long[] a6b = new Count.Plong().array(SZ + 3);
        ArrayShow.show(a6b);

        System.out.println("Float");
        Float[] a7 = new Float[SZ];
        Arrays.setAll(a7, new Count.Float()::get);
        ArrayShow.show(a7);

        a7 = Stream.generate(new Count.Float())
                .limit(SZ + 1)
                .toArray(Float[]::new);
        ArrayShow.show(a7);
        a7 = new Count.Float().array(SZ + 2);
        ArrayShow.show(a7);
        float[] a7b = new Count.Pfloat().array(SZ + 3);
        ArrayShow.show(a7b);

        System.out.println("Double");
        Double[] a8 = new Double[SZ];
        Arrays.setAll(a8, new Count.Double()::get);
        ArrayShow.show(a8);

        a8 = Stream.generate(new Count.Double())
                .limit(SZ + 1)
                .toArray(Double[]::new);
        ArrayShow.show(a8);
        a8 = new Count.Double().array(SZ + 2);
        ArrayShow.show(a8);
        double[] a8b = new Count.Pdouble().array(SZ + 3);
        ArrayShow.show(a8b);
    }
}
