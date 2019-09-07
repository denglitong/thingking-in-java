package com.denglitong.streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @autor denglitong
 * @date 2019/8/29
 */
public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(String filePath) throws Exception {
        Files.lines(Paths.get(filePath))
                .skip(1)
                .forEach(line -> {
                    for (String w : line.split("[ .?,]+")) {
                        builder.add(w);
                    }
                });
    }

    // 只要你不调用stream()方法，就可以继续向builder对象中添加单词
    // 调用stream()方法后继续尝试添加单词会产生一个异常
    Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) throws Exception {
        String filePath = "/Users/leon/javaspace/thingking-in-java/chapter14/src/Cheese.dat";
        new FileToWordsBuilder(filePath)
                .stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
