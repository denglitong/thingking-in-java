package com.denglitong.collections;

import java.util.Iterator;

/**
 * 实现iterable接口，该接口包含一个能够生产Iterator的iterator()方法
 * for-in使用Iterable接口来遍历序列
 *
 * @autor denglitong
 * @date 2019/8/23
 */
public class IterableClass implements Iterable<String> {
    protected String[] words = ("And that is how " +
            "we know the Earth to be banana-shaped").split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }

    public static void main(String[] args) {
        for (String s : new IterableClass()) {
            System.out.print("'" + s + "' ");
        }
        System.out.println();
    }
}
