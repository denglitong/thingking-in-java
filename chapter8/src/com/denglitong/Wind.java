package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/27
 */

class Instrucment {
    public void play() {}

    static void tune(Instrucment i) {
        // ...
        i.play();
    }
}

public class Wind extends Instrucment {
    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrucment.tune(flute); // Upcasting 向上转型
    }
}
