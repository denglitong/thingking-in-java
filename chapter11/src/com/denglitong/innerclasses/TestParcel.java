package com.denglitong.innerclasses;

/**
 * private内部类给类的设计者提供了一种途径：通过这种方式可以完全阻止任何依赖于类型的编码，
 * 并且完全隐藏了实现的细节。从使用者角度看，由于不能访问任何新增加的、原本不属于公共接口的
 * 方法，所以扩展接口是没有价值的。
 * @autor denglitong
 * @date 2019/8/4
 */
class Parcel4 {
    // 内部类的访问权限可以设置为private，
    // 这点和非内部类不同（非内部类只能设置为public/package访问权限）
    private class PContents implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    protected final class PDestination implements Destination {
        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }
}

public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
        // illegal -- can't access private class
        // Parcel4.PContents pc = p.new PContents();
    }
}
