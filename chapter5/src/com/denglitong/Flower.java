package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/21
 */
public class Flower {

    int petalCount = 0;
    String s = "initial value";

    Flower(int petals) {
        petalCount = petals;
        System.out.println("Constructor w/ int arg only, petalCount= " + petalCount);
    }

    Flower(String ss) {
        s = ss;
        System.out.println("Constructor w/ String arg only, s = " + ss);
    }

    Flower(String s, int petals) {
        // this(petals);
        // Call to this must be first statement in Constructor
        // and you can't call this() two times
        // this(s);
        // this.s = s;
        this(s);
        petalCount = petals;
        System.out.println("String & int args");
    }

    Flower() {
        this("hi", 47);
        System.out.println("default constructor (no args)");
    }

    void printPetalCount() {
        // this(11); call this() must be in constructor
        System.out.println("petalCount = " + petalCount + " s = " + s);
    }

    public static void main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();
    }

}
