package com.denglitong.functional;

/**
 * @autor denglitong
 * @date 2019/8/24
 */
class This {
    void two(int i, double d) {
        System.out.println("two args");
    }
    void three(int i, double d, String s) {
        System.out.println("three args");
    }
    void four(int i, double d, String s, char c) {
        System.out.println("four args");
    }
}

interface TwoArgs {
    // 对为绑定的函数引用，其实但函数接口某人第一个参数是对应的类对象
    // 正是通过该默认参数才能去触发对应的绑定函数的调用
    void call2(This athis, int i, double d);
}

interface ThreeArgs {
    void call3(This athis, int i, double d, String s);
}

interface FourArgs {
    void call4(This athis, int i, double d, String s, char c);
}

public class MultiUnbound {
    public static void main(String[] args) {
        TwoArgs twoArgs = This::two;
        ThreeArgs threeArgs = This::three;
        FourArgs fourArgs = This::four;
        This athis = new This();
        twoArgs.call2(athis, 11, 3.14);
        threeArgs.call3(athis, 11, 3.14, "Three");
        fourArgs.call4(athis, 11, 3.14, "Foud", 'Z');
    }
}
