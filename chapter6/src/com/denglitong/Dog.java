package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/20 21:13
 */
public class Dog {

    public void bark(int p) {
        System.out.println("barking");
    }

    public void bark(long p) {
        System.out.println("howling");
    }

    public void bark(int p, String s) {
        System.out.println("int " + p + ", String " + s);
    }

    public void bark(String s, int p) {
        System.out.println("String " + s + ", int " + p);
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark(0);
        dog.bark(0L);
        dog.bark(0, "barking");
        dog.bark("howling", 0);

        new DefaultInitialize();
    }

}

class DefaultInitialize {

}
