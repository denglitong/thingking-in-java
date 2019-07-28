package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/28
 */
public class Brass extends Wind {
    @Override
    public void play(Note note) {
        System.out.println("Brass.play() " + note);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Brass");
    }
}
