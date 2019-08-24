package com.denglitong.collections;

/**
 * @autor denglitong
 * @date 2019/8/18
 */
public class StackTest2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String s : "My dog has fleas".split(" ")) {
            stack.pust(s);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        java.util.Stack<String> stack1 = new java.util.Stack<>();
        for (String s : "My dog has fleas".split(" ")) {
            stack1.push(s);
        }
        while (!stack1.empty()) {
            System.out.print(stack1.pop() + " ");
        }
        System.out.println();
    }
}
