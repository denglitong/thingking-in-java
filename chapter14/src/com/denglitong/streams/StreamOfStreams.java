package com.denglitong.streams;

import java.util.stream.Stream;

/**
 * @autor denglitong
 * @date 2019/9/1
 */
public class StreamOfStreams {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .map(e -> e.getClass().getName())
                .forEach(System.out::println);
    }
}
