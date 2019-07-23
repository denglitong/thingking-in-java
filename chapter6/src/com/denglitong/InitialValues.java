package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/21
 */
public class InitialValues {

    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;

    InitialValues() {
        // 字段的自动初始化在构造函数之前进行，于是 i 先被默认初始化为 0，
        // 然后再在构造函数里面被初始化为 7
        // 字段都会在任何函数被调用之前初始化，而不在于它们和函数定义的先后顺序，
        // 但是字段的先后顺序和他们初始化的顺序是一致的，即定义在前面的字段先初始化
        i = 7;
    }

    void printInitialValues() {
        System.out.println("Data type\tInitialValue");
        System.out.println("boolean " + t);
        System.out.println("char [" + c + "], c == 0 " + (c==0));
        System.out.println("byte " + b);
        System.out.println("short " + s);
        System.out.println("int " + i);
        System.out.println("float " + f);
        System.out.println("double " + d);
        System.out.println("reference " + reference);
    }

    public static void main(String[] args) {
        new InitialValues().printInitialValues();
    }

}

class Window {

    Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }

}

class House {

    Window w1 = new Window(1);

    House() {
        System.out.println("House()");
        w3 = new Window(33);
    }


    Window w3 = new Window(3);
    Window w2 = new Window(2);

    void f() {
        System.out.println("f()");
    }


    public static void main(String[] args) {
        new House().f();
    }

}
