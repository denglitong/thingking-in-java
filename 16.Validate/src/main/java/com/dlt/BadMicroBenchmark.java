package com.dlt;

import java.util.Arrays;

/**
 * @author denglitong
 * @date 2021/1/5
 */
public class BadMicroBenchmark {
    static final int SIZE = 25_000_000;

    public static void main(String[] args) {
        try {
            long[] la = new long[SIZE];
            System.out.println("setAll: " + Timer.duration(() -> Arrays.setAll(la, n -> n)));
            // 并行不一定更快，可能会争抢资源
            System.out.println("parallelSetAll: " + Timer.duration(() -> Arrays.parallelSetAll(la, n -> n)));
        } catch (OutOfMemoryError e) {
            System.out.println("Insufficient memory");
            System.exit(0);
        }
    }
}
