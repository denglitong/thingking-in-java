package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/21
 */
public class Book {

    boolean checkout = false;

    Book(boolean checkout) {
        this.checkout = checkout;
    }

    void checkIn() {
        checkout = false;
    }

    protected void finalize() {
        if (checkout) {
            System.out.println("Error: checked out");
            // Normally, you'll also do this:
            // super.finalize();
        }
    }

    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        // finalize print checked in book, but here new Book(true) forget to check in
        // and we can found it in finalize() to figure out such instance
        new Book(true);
        // 强制手动gc
        System.gc();
    }

}

class FinalizeTest {

    protected void finalize() {
        System.out.println("in finalize");
    }

    public static void main(String[] args) {
        new FinalizeTest();
        System.gc();
    }

}

class Tank {

    boolean empty;

    Tank(boolean empty) {
        this.empty = empty;
    }

    protected void finalize() {
        if (empty) {
            System.out.println("Info: empty");
            // super.finalize();
        } else {
            System.out.println("Error: not empty");
        }
    }

    public static void main(String[] args) {
        new Tank(false);
        new Tank(true);
        System.gc();
        // int i;
        // java: 可能尚未初始化变量i，但是基本类型如果是类的数据成员则会有默认值，局部变量则没有
        // i++;
    }

}