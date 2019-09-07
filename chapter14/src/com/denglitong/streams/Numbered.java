package com.denglitong.streams;

import java.util.stream.Stream;

/**
 * @autor denglitong
 * @date 2019/9/1
 */
public class Numbered {
    final int n;
    public Numbered(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Numbered(" + n + ")";
    }

    /**
     * map()将一个字符串映射为另一个字符串，
     * 我们完全可以产生和接受类型完全不同的类型，从而改变刘的数据类型
     *
     * @param args
     */
    public static void main(String[] args) {
        // 将获取到的整数通过构造器 Numbered::new 转化为 Numbered 类型
        Stream.of(1, 5, 7, 9, 11, 13)
                .map(Numbered::new)
                .forEach(System.out::println);
    }
}
