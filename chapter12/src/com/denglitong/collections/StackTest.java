package com.denglitong.collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @autor denglitong
 * @date 2019/8/18
 */
public class StackTest {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
