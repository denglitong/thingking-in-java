package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/28
 */

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        // draw()方法被复写，则动态绑定时调用的也是派生类的方法
        // 但是此时派生类只是部分初始化（知道基类型以及初始化基类型，如果draw需要用到派生类的属性值但此时派生类的属性值还没初始化，此时可能会产生意外的结果，此时属性值没有初始化，只能取默认值，这是副作用）
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    public RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
