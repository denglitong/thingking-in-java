package com.denglitong.innerclasses;

/**
 * @autor denglitong
 * @date 2019/8/4
 */
abstract class Base {
    protected int f;
    Base(int i) {
        System.out.println("Base constructor, i = " + i);
    }
    public abstract void f();
}

public class AnonymousConstructor {
    public static Base getBase(int i) {
        return new Base(i) {
            // static code block, effectively like initializer
            {
                System.out.println("Inside instance initializer");
                f = i;
            }

            @Override
            public void f() {
                System.out.println("In anonymous f(), f = " + f);
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}
