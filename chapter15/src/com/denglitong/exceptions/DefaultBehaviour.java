package com.denglitong.exceptions;

/**
 * @autor denglitong
 * @date 2019/9/13
 */
public class DefaultBehaviour {
    public static void f(String s) {
        // will break as long as one case match
        // if none match, that flow into default
        switch (s) {
            case "a":
                System.out.println("str: " + s);
                break;
            case "b":
                System.out.println("hello: " + s);
                break;
            default:
                System.out.println("default: " + s);
                break;
        }
    }

    public static void main(String[] args) {
        f("a");
        f("b");
        f("c");
    }
}
