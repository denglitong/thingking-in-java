package com.denglitong.exceptions;

/**
 * @autor denglitong
 * @date 2019/9/8
 */
public class WhoCalled {
    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                // System.out.println(ste.getMethodName());
                System.out.println(ste);
            }
        }
    }

    static void g() { f(); }
    static void h() { g(); }
    public static void main(String[] args) {
        f();
        System.out.println("******");
        g();
        System.out.println("******");
        h();
    }
}
