package com.denglitong.innerclasses;

/**
 * 嵌套类
 * 如果不需要内部类对象与其外围类对象之间有联系，那么可以将内部类声明为 static，这通常被称为嵌套类。
 * 普通内部类对象隐式地保存了一个引用，指向创建它的外围类对象，然后当内部类是 static 时就不是这样了
 *
 * @autor denglitong
 * @date 2019/8/4
 */
public class Parcel11 {

    private static class ParcelContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected static final class ParcelDestination implements Destination {
        private String label;

        private ParcelDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }

        // nested classes can contain other static elements:
        public static void f() {}
        static int x = 10;

        static class AnotherLevel {
            public static void f() {}
            static int x = 10;
        }
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }

    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
        System.out.println(c.value());
        System.out.println(d.readLabel());
    }

}
