package com.denglitong.functional;

import java.util.function.Function;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
class One {}
class Two {}

public class ConsumeFunction {
    static Two consume(Function<One, Two> oneTwo) {
        return oneTwo.apply(new One());
    }

    public static void main(String[] args) {
        Two two = consume(one -> new Two());
    }
}
