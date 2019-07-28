package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/27
 */
public class Instrument {
    public void play(Note note) {
        System.out.println("Instrument.play()");
    }

    String what() {
        return "Instrument";
    }

    void adjust() {
        System.out.println("Adjusting Instrument");
    }
}
