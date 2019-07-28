package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/28
 */
public class Woodwind extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Woodwind.play() " + note);
    }

    @Override
    String what() {
        return "Woodwind";
    }
}
