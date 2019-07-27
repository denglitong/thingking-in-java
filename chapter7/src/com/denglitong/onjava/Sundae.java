package com.denglitong.onjava;

/**
 * @autor denglitong
 * @date 2019/7/24
 */
public class Sundae {

    // 控制如何创建对象，将构建函数声明为private则不能通过new来创建实例
    private Sundae() {}

    static Sundae makeASundae() {
        return new Sundae();
    }

}

class IceCream {

    public static void main(String[] args) {
        Sundae x = Sundae.makeASundae();
    }

}
