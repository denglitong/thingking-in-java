package com.denglitong.music5;

/**
 * @autor denglitong
 * @date 2019/7/30
 */

enum Note {
    MIDDLE_C,
}

interface Instrument {

    int VALUE = 5;

    default void play(Note note) {
        System.out.println(this + ".play() " + note);
    }

    default void adjust() {
        System.out.println("Adjusting " + this);
    }

}

class Wind implements Instrument {

    @Override
    public String toString() {
        return "Wind";
    }

}

class Percussion implements Instrument {

    @Override
    public String toString() {
        return "Percussion";
    }

}

class Stringed implements Instrument {

    @Override
    public String toString() {
        return "Stringed";
    }

}

class Brass extends Wind {

    @Override
    public String toString() {
        return "Brass";
    }

}

class Woodwind extends Wind {

    @Override
    public String toString() {
        return "Woodwind";
    }

}

public class Music5 {

    static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind(),
        };
        tuneAll(orchestra);
    }

}
