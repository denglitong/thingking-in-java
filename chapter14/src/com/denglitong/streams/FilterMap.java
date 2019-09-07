package com.denglitong.streams;

import java.util.stream.Stream;

/**
 * flatMap 将 stream 打平，从映射返回的每个流都会自动扁平为组成它的字符串
 *
 * @autor denglitong
 * @date 2019/9/1
 */
public class FilterMap {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("Gonzo", "Fozzie", "Beaker"))
                .forEach(System.out::println);
    }
}
