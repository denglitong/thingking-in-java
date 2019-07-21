package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/21
 */
public class Bowl {

    Bowl(int marker) {
        System.out.println("Bowl("+ marker +")");
    }

    void f1(int marker) {
        System.out.println("f1("+ marker +")");
    }

}

class Table {

    static Bowl bowl1 = new Bowl(1);

    Table() {
        System.out.println("Table");
        bowl1.f1(1);
    }

    void f2(int marker) {
        System.out.println("f2("+marker+")");
    }

    static Bowl bowl2 = new Bowl(2);

}

class Cupboard {

    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);
    Cupboard() {
        System.out.println("Cupboard");
        bowl4.f1(2);
    }

    void f3(int marker) {
        System.out.println("f3("+ marker +")");
    }

    static Bowl bowl5 = new Bowl(5);

    /**
     * static 静态数据在类调用时才会初始化（且只会初始化一次），其默认值在类初始化之前被初始化
     * 即使没有显式的使用static，类的构造方法也是static静态方法
     *
     * 首次创建Dog对象时，或者Dog类的静态方法/静态域首次被访问时，JVM查找Dog.class文件（从classpath）
     * 载入Dog.class（这将创建一个Class对象），这时有关静态初始化的所有动作都会被执行（静态方法或静态域），并且静态初始化只在Class对象首次加载的时候进行一次
     * 当new Dog()对象的时候，首先在堆上为Dog对象分配足够的存储空间，并且将这块空间清零，即基本类型会置为默认值如0，引用被置为默认值null
     * 执行所有出现于字段定义处的初始化动作（如 int i = 7;的赋值， i先前已被赋值过默认值0）
     * 执行构造器
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Creating new Cupboard() in main");
        new Cupboard();
        System.out.println("Creating new Cupboard() in main");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }

    static int i = 47;
    // static block 静态块
    static {
        i = 47;
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();

}
