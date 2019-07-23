package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/23
 */
public class VarArgsMain {
    public static void main(String... args) {
        for (String s : args) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
