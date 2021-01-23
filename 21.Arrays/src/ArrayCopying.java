import java.util.Arrays;

/**
 * @author denglitong
 * @date 2021/1/23
 */
class Sup {
    private int id;
    public Sup(int n) {
        this.id = n;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + id;
    }
}

class Sub extends Sup {
    public Sub(int n) {
        super(n);
    }
}

public class ArrayCopying {
    public static final int SZ = 15;

    public static void main(String[] args) {
        int[] a1 = new int[SZ];
        Arrays.setAll(a1, new Count.Integer()::get);
        ArrayShow.show("a1", a1);

        int[] a2 = Arrays.copyOf(a1, a1.length);
        Arrays.fill(a1, 1);
        ArrayShow.show("a1", a1);
        ArrayShow.show("a2", a2);
        a2 = Arrays.copyOf(a2, a2.length / 2);
        ArrayShow.show("a2", a2);

        Integer[] a3 = new Integer[SZ];
        Arrays.setAll(a3, new Count.Integer()::get);
        ArrayShow.show("a3", a3);
        Integer[] a4 = Arrays.copyOfRange(a3, 4, 12);
        ArrayShow.show("a4", a4);

        Sub[] d = new Sub[SZ / 2];
        Arrays.setAll(d, Sub::new);
        ArrayShow.show("d", d);

        // copy 对象只是 copy 引用，"浅拷贝"
        Sup[] b = Arrays.copyOf(d, d.length, Sup[].class);
        ArrayShow.show("b", b);
        // 这里看似可以 super cast sub 但其实持有的都是 sub 的引用
        Sub[] d2 = Arrays.copyOf(b, b.length, Sub[].class);
        ArrayShow.show("d2", d2);

        Sup[] b2 = new Sup[SZ / 2];
        Arrays.setAll(b2, Sup::new);
        try {
            // superclass cast to subclass error:
            Sub[] d3 = Arrays.copyOf(b2, b2.length, Sub[].class);
        } catch (Exception e) {
            // java.lang.ArrayStoreException
            System.out.println(e);
        }
    }
}
