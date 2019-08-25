package com.denglitong.functional;

import java.util.function.BiConsumer;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class BiConsumerPermutations {
    // %n 换行，是自动跨平台的，比 \n 好
    static BiConsumer<Integer, Double> bicid = (i, d) ->
            System.out.format("%d, %f%n", i, d);
    static BiConsumer<Double, Integer> bicdi = (d, i) ->
            System.out.format("%d, %f%n", i, d);
    static BiConsumer<Integer, Long> bicil = (i, l) ->
            System.out.format("%d, %d%n", i, l);

    public static void main(String[] args) {
        bicid.accept(47, 11.34);
        bicdi.accept(22.45, 92);
        bicil.accept(1, 11L);
    }
}
