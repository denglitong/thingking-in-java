import java.util.function.*;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
class Foo {
    public Foo() {
        System.out.println("Foo");
    }
}

class Bar {
    Foo f;
    public Bar(Foo f) {
        this.f = f;
        System.out.println("Bar");
    }
}

class IBaz {
    int i;
    public IBaz(int i) {
        this.i = i;
        System.out.println("IBaz " + i);
    }
}

class LBaz {
    long l;
    public LBaz(long l) {
        this.l = l;
        System.out.println("LBaz " + l);
    }
}

class DBaz {
    double d;
    public DBaz(double d) {
        this.d = d;
        System.out.println("DBaz " + d);
    }
}

public class FunctionVariants {
    static Function<Foo, Bar> f1 = f -> new Bar(f);
    static IntFunction<IBaz> f2 = i -> new IBaz(i);
    static LongFunction<LBaz> f3 = l -> new LBaz(l);
    static DoubleFunction<DBaz> f4 = d -> new DBaz(d);
    static ToIntFunction<IBaz> f5 = ib -> ib.i;
    static ToLongFunction<LBaz> f6 = lb -> lb.l;
    static ToDoubleFunction<DBaz> f7 = db -> db.d;
    static IntToLongFunction f8 = i -> i;
    static IntToDoubleFunction f9 = i -> i;
    // 有些情况下需要进行强制类型转换否则编译器会报错
    static LongToIntFunction f10 = l -> (int)l;
    static LongToDoubleFunction f11 = l -> (double)l;
    static DoubleToIntFunction f12 = d -> (int)d;
    static DoubleToLongFunction f13 = d -> (long)d;

    public static void main(String[] args) {
        Bar b = f1.apply(new Foo());
        IBaz ib = f2.apply(11);
        LBaz lb = f3.apply(11);
        DBaz db = f4.apply(11);

        int i = f5.applyAsInt(ib);
        System.out.println(i);
        long l = f6.applyAsLong(lb);
        System.out.println(l);
        double d = f7.applyAsDouble(db);
        System.out.println(d);

        l = f8.applyAsLong(12);
        System.out.println(l);
        d = f9.applyAsDouble(12);
        System.out.println(d);
        i = f10.applyAsInt(12);
        System.out.println(i);
        d = f11.applyAsDouble(12);
        System.out.println(d);
        i = f12.applyAsInt(13.4);
        System.out.println(i); // 13
        l = f13.applyAsLong(13.5);
        System.out.println(l); // 13
    }
}
