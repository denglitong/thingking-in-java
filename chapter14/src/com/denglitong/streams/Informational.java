package com.denglitong.streams;

/**
 * @autor denglitong
 * @date 2019/9/7
 */
public class Informational {
    public static void main(String[] args) throws Exception {
        String filePath = "/Users/leon/javaspace/thingking-in-java/chapter14/src/Cheese.dat";

        System.out.println(
                FileToWords.stream(filePath).count()
        );
        System.out.println(
                FileToWords.stream(filePath)
                        .min(String.CASE_INSENSITIVE_ORDER)
                        .orElse("NONE")
        );
        System.out.println(
                FileToWords.stream(filePath)
                        .max(String.CASE_INSENSITIVE_ORDER)
                        .orElse("NONE")
        );
    }
}
