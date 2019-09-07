package com.denglitong.streams;

/**
 * @autor denglitong
 * @date 2019/8/31
 */
public class Peeking {
    public static void main(String[] args) throws Exception {
        String filePath = "/Users/leon/javaspace/thingking-in-java/chapter14/src/Cheese.dat";
        FileToWords.stream(filePath)
                .skip(21)
                .limit(4)
                .map(w -> w + " ")
                .peek(System.out::print)
                .map(String::toLowerCase)
                .forEach(System.out::print);
    }
}
