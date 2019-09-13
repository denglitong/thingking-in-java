package com.denglitong.exceptions;

/**
 * @autor denglitong
 * @date 2019/9/8
 */
class MyException extends Exception {
    public MyException() {
    }
    public MyException(String message) {
        super(message);
    }
}

public class FullConstructors {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("originated in g()");
    }

    public static void main(String[] args) throws Exception {
        try {
            f();
        } catch (MyException e) {
            // 它将打印"从方法调用处直到异常抛出处"的方法调用序列
            e.printStackTrace(System.out);
        }

        Thread.sleep(1000);
        try {
            g();
        } catch (MyException e) {
            // e.printStackTrace(System.err);
            // 默认版本信息将被输出到标准错误率，也即System.err
            e.printStackTrace();
        }
    }
}
