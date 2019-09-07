package com.denglitong.streams;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * allMatch(Predicate) 如果每个流元素都返回true, 则结果为true，
 * &nbsp; 该操作会在第一个false之后短路,即不会在发生false之后继续执行计算
 * anyMatch(Predicate) 如果流任一元素返回true，则提前短路返回true，短路之后不会再继续执行计算
 * noneMatch(Predicate) 如果流元素都返回false，则返回false，如果任一元素返回true则提前短路
 *
 * @autor denglitong
 * @date 2019/9/7
 */

interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {}

public class Matching {
    static void show(Matcher matcher, int val) {
        System.out.println(
                matcher.test(
                        IntStream.rangeClosed(1, 9)
                                .boxed()
                                .peek(n -> System.out.format("%d ", n)),
                        n -> n < val
                )
        );
    }

    public static void main(String[] args) {
        show(Stream::allMatch, 10);
        show(Stream::allMatch, 4);
        show(Stream::anyMatch, 2);
        show(Stream::anyMatch, 0);
        show(Stream::noneMatch, 5);
        show(Stream::noneMatch, 0);
    }
}
