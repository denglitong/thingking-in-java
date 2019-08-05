package com.denglitong.innerclasses;

/**
 * @autor denglitong
 * @date 2019/8/4
 */
public class Parcel7 {
    public Contents contents() {
        // MyContent version1
        return new Contents() {
            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        }; // semicolon required
    }

    // MyContent version2
    class MyContent implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    public Contents contents2() {
        return new MyContent();
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
        System.out.println(c.value());
        System.out.println(p.contents2().value());
    }
}
