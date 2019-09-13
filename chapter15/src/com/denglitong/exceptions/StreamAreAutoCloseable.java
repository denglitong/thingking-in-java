package com.denglitong.exceptions;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @autor denglitong
 * @date 2019/9/13
 */
public class StreamAreAutoCloseable {
    public static void main(String[] args) throws IOException {
        // 资源规范头中可以包含多个定义，通过分好进行分割，最后一个分好是可选的
        // 规范头中定义的每个对象都会在 try 语句块运行结束之后都调用 close 方法
        try (
                Stream<String> in = Files.lines(Paths.get("StreamAreCloseable.java"));
                PrintWriter outfile = new PrintWriter("Results.txt");
        ) {
            in.skip(5).limit(1).map(String::toLowerCase).forEach(outfile::println);
        }
    }
}
