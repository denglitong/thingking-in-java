package com.denglitong.streams;

import java.util.Date;

/**
 * @autor denglitong
 * @date 2019/9/5
 */
public class ForEach {
    static final int SIZE = 14;
    public static void main(String[] args) {
        // forEach 顺序输出
        Date d1 = new Date();
        RandInts.rands().limit(SIZE)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        System.out.println(new Date().getTime() - d1.getTime());

        d1 = new Date();
        // parallel 并行输出（由于多个处理器正在运行该程序），乱序
        RandInts.rands().limit(SIZE)
                .parallel()
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        System.out.println(new Date().getTime() - d1.getTime());

        // forEachOrdered 并发输出，有序
        d1 = new Date();
        RandInts.rands().limit(SIZE)
                .parallel()
                .forEachOrdered(n -> System.out.format("%d ", n));
        System.out.println();
        System.out.println(new Date().getTime() - d1.getTime());
    }
}