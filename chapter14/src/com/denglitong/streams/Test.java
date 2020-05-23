package com.denglitong.streams;

import java.math.BigDecimal;

/**
 * @autor denglitong
 * @date 2019/9/24
 */

interface Trait {
    default void summarize() {
        System.out.println("Trait summarize");
    }
}

class Impl1 implements Trait {

}

public class Test {

    public Trait returnTrait() {
        return new Impl1();
    }

    public static void main(String[] args) {
        // for (int i = 1; i < 10; i++) {
        //     System.out.println("i: " + i + ", fibo: " + fibo2(i));
        // }
        // System.out.println(fibo2(100));

        new Test().returnTrait().summarize();
    }

    // n: 1 2 3 4 5 6
    //    1 1 2 3 5 8
    public static BigDecimal fibo2(int n) {
        if (n <= 2) {
            return BigDecimal.valueOf(1);
        }

        BigDecimal a = BigDecimal.valueOf(1);
        BigDecimal b = BigDecimal.valueOf(1);
        BigDecimal t;

        for (int i = 3; i <= n; i++) {
            t = new BigDecimal(b.toString());
            b = a.add(b);
            a = new BigDecimal(t.toString());
        }

        return b;
    }
}
