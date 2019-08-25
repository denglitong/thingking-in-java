package com.denglitong.functional;

/**
 * Runnable接口符合特殊的单方法接口格式：它的方法run()不带参数也没有返回值
 * 因此可以使用Lambda表达式和方法引用作为Runnable:
 *
 * @autor denglitong
 * @date 2019/8/24
 */
class Go {
    static void go() {
        System.out.println("Go::go");
    }
}

public class RunnableMethodReference {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        new Thread(() -> System.out.println("lambda")).start();

        new Thread(Go::go).start();
    }
}
