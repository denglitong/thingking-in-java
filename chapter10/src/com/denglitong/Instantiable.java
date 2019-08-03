package com.denglitong;

/**
 * 接口只允许public方法
 * 如果不加访问修饰符的话，接口的方法不是friendly(包权限)而是public
 * @autor denglitong
 * @date 2019/7/28
 */
abstract class Uninstantiable {
    abstract void f();
    abstract int g();
}

public class Instantiable extends Uninstantiable {
    @Override
    void f() {
        System.out.println("f()");
    }

    @Override
    int g() {
        return 22;
    }

    public static void main(String[] args) {
        Uninstantiable ui = new Instantiable();
        ui.f();
        System.out.println(ui.g());
    }
}
