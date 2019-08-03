package com.denglitong.interfaces;

/**
 * @autor denglitong
 * @date 2019/8/1
 */
interface I1 {

    void f();

}

interface I2 {
    int f(int i);

}

interface I3 {

    int f();

}

class C {

    public int f() {
        return 1;
    }

}

class C2 implements I1, I2 {

    @Override
    public void f() {

    }

    @Override
    public int f(int i) {
        return 1; //
    }

}

class C3 extends C implements I2 {

    @Override
    public int f(int i) {
        return 1; //
    }

}

/**
 * 继承的基类和接口中冲突方法完全相同，没问题
 */
class C4 extends C implements I3 {

    @Override
    public int f() {
        return 1;
    }

}

/**
 * 在不显式声明冲突函数的情况下，在基类和接口的冲突方法返回类型不一样时会报错
 */
// class C5 extends C implements I1 {
//
// }

/**
 * 声明接口的时候，对于冲突的方法不管是否显式声明都不能创建
 */
// interface I4 extends I1, I3 {
//
//     @Override
//     void f();
//
// }

public class InterfaceCollision {
    public static void main(String[] args) {
    }
}

class Test {
    public static void main(String[] args) {

    }

    public void some() {
    }

    private void thing() {
    }

    private void h() {
        int i = 1 + 2;
        long first = 1L;
        int second = (int)first;
    }
}