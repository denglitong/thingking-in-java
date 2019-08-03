package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/31
 */
public class BandPass extends Filter {

    double lowCutoff, highCutoff;

    public BandPass(double lowCutoff, double highCutoff) {
        this.lowCutoff = lowCutoff;
        this.highCutoff = highCutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }

}
