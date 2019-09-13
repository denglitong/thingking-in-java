package com.denglitong.exceptions;

/**
 * @autor denglitong
 * @date 2019/9/13
 */
public class Switch {
    private boolean state = false;
    public boolean read() {
        return state;
    }
    public void on() {
        state = true;
        System.out.println(this);
    }
    public void off() {
        state = false;
        System.out.println(this);
    }
    @Override
    public String toString() {
        return state ? "on" : "off";
    }
}
