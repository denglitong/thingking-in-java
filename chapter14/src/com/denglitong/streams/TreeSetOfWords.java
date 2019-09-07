package com.denglitong.streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 在 Collectors 里面没有特定的 toTreeSet() 方法，但是你可以使用 Collectors.toCollections()
 * 并为任何类型的 Collection 提供构造函数引用
 *
 * @autor denglitong
 * @date 2019/9/7
 */
public class TreeSetOfWords {
    public static void main(String[] args) throws Exception {
        String filePath = "/Users/leon/javaspace/thingking-in-java/chapter14/src/com/denglitong/streams/TreeSetOfWords.java";
        Set<String> words2 = Files.lines(Paths.get(filePath))
                .flatMap(s -> Arrays.stream(s.split("\\W+")))
                .filter(s -> !s.matches("\\d+"))
                .map(String::trim)
                .filter(s -> s.length() > 2)
                .limit(100)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(words2);
    }
}
