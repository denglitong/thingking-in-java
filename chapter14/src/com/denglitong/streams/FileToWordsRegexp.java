package com.denglitong.streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @autor denglitong
 * @date 2019/8/31
 */
public class FileToWordsRegexp {
    private String all;

    public FileToWordsRegexp(String filePath) throws Exception {
        all = Files.lines(Paths.get(filePath))
                .skip(1)
                .collect(Collectors.joining());
        System.out.println("===");
        System.out.println(all);
        System.out.println("===");
    }

    // 这里有个问题，就是此处的stream()方法返回一个流，依赖了变量all来存储整个文件
    // 但是流本身是不需要关心存储的，而且流是懒加载的，该种方式需要避免
    public Stream<String> stream() {
        return Pattern.compile("[ .,?]+").splitAsStream(all);
    }

    public static void main(String[] args) throws Exception {
        String filePath = "/Users/leon/javaspace/thingking-in-java/chapter14/src/Cheese.dat";
        FileToWordsRegexp fw = new FileToWordsRegexp(filePath);
        fw.stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::println);
    }
}
