package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/31
 */
public class Filter {

    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }

}
