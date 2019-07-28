package com.denglitong;

import java.util.Random;

/**
 * @autor denglitong
 * @date 2019/7/27
 */

class Shape {
    public void draw() {}
    public void erase() {}
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Circle.erase");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Square draw");
    }

    @Override
    public void erase() {
        System.out.println("Square erase");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle draw");
    }

    @Override
    public void erase() {
        System.out.println("Triangle erase");
    }
}

public class RandomShapes {
    private Random rand = new Random(47);

    public Shape get() {
        switch (rand.nextInt(3)) {
            default:
            case 0: return new Circle();
            case 1: return new Square();
            case 2: return new Triangle();
        }
    }

    public Shape[] array(int size) {
        Shape[] shapes = new Shape[size];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = get();
        }
        return shapes;
    }
}
