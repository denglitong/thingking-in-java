package com.denglitong.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * @autor denglitong
 * @date 2019/8/18
 */
public class SetOfString {
    public static void main(String[] args) {
        Set<String> colors = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Red");
            colors.add("Orange");
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Purple");
        }
        // HashSet not sorted elements
        System.out.println(colors);
    }
}
