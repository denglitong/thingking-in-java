package com.dlt;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;

import java.util.Arrays;

/**
 * @author denglitong
 * @date 2021/1/5
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
// 默认运行次数是 20
@Warmup(iterations = 5)
// 默认运行次数是 20
@Measurement(iterations = 5)
// Fork 指定每个测试运行的次数，默认是 10
@Fork(1)
public class JMH1 {
    private long[] la;

    @Setup
    public void setUp() {
        la = new long[250_000_000];
    }

    @Benchmark
    public void setAll() {
        Arrays.setAll(la, n -> n);
    }

    @Benchmark
    public void parallelSetAll() {
        Arrays.parallelSetAll(la, n -> n);
    }

    @Test
    public void benchmark() throws Exception {
        String[] argv = {};
        org.openjdk.jmh.Main.main(argv);
    }
}
