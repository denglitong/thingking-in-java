import java.util.Comparator;
import java.util.function.*;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
class AA {
    // AA() { System.out.println("AA()"); }
}
class BB {
    // BB() { System.out.println("BB"); }
}
class CC {
    // CC() { System.out.println("CC"); }
}

public class ClassFunctionals {
    // supplier
    static AA f1() { return new AA(); }
    // comparator
    static int f2(AA aa1, AA aa2) { return 1; }
    // consumer
    static void f3(AA aa) {}
    // bi consumer
    static void f4(AA aa, BB bb) {}
    // function
    static CC f5(AA aa) { return new CC(); }
    // bi function
    static CC f6(AA aa, BB bb) { return new CC(); }
    // predicate
    static boolean f7(AA aa) { return true; }
    // bi predicate
    static boolean f8(AA aa, BB bb) { return true; }
    // unary operator
    static AA f9(AA aa) { return new AA(); }
    // binary operator
    static AA f10(AA aa1, AA aa2) { return new AA(); }

    public static void main(String[] args) {
        Supplier<AA> s = ClassFunctionals::f1;
        // get the result
        // 一旦将方法引用赋值给函数接口，我们就可以调用与该接口关联的函数方法
        // 如get(), compare(), accept(), apply(), test()
        System.out.println(s.get());
        Comparator<AA> c = ClassFunctionals::f2;
        System.out.println(c.compare(new AA(), new AA()));
        Consumer<AA> cons = ClassFunctionals::f3;
        cons.accept(new AA());
        BiConsumer<AA, BB> bicons = ClassFunctionals::f4;
        bicons.accept(new AA(), new BB());

        Function<AA, CC> f = ClassFunctionals::f5;
        CC cc = f.apply(new AA());
        System.out.println(cc);
        BiFunction<AA, BB, CC> bif = ClassFunctionals::f6;
        cc = bif.apply(new AA(), new BB());
        System.out.println(cc);

        Predicate<AA> p = ClassFunctionals::f7;
        boolean result = p.test(new AA());
        System.out.println(result);
        BiPredicate<AA, BB> bip = ClassFunctionals::f8;
        result = bip.test(new AA(), new BB());
        System.out.println(result);

        UnaryOperator<AA> uo = ClassFunctionals::f9;
        AA aa = uo.apply(new AA());
        System.out.println(aa);
        BinaryOperator<AA> bo = ClassFunctionals::f10;
        aa = bo.apply(new AA(), new AA());
        System.out.println();
    }
}
