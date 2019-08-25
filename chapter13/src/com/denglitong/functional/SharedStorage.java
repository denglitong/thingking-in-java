package com.denglitong.functional;

import java.util.function.IntSupplier;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class SharedStorage {
    public static void main(String[] args) {
        Closure1 c1 = new Closure1();
        IntSupplier f1 = c1.makeFun(0);
        IntSupplier f2 = c1.makeFun(0);
        IntSupplier f3 = c1.makeFun(0);
        System.out.println(f1.getAsInt());
        System.out.println(f2.getAsInt());
        System.out.println(f3.getAsInt());

        Closure2 c2 = new Closure2();
        IntSupplier f4 = c2.makeFun(0);
        IntSupplier f5 = c2.makeFun(0);
        System.out.println(f4.getAsInt());
        System.out.println(f5.getAsInt());

        Closure3 c3 = new Closure3();
        IntSupplier f6 = c3.makeFun(1);
        System.out.println(f6.getAsInt());

        Closure4 c4 = new Closure4();
        IntSupplier f7 = c4.makeFun(1);
        System.out.println(f7.getAsInt());

        Closure6 c6 = new Closure6();
        IntSupplier f8 = c6.makeFun(0);
        IntSupplier f9 = c6.makeFun(0);
        System.out.println(f8.getAsInt());
        System.out.println(f9.getAsInt());
    }
}
