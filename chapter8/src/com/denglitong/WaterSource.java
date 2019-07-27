package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/25
 */
public class WaterSource {

    private String s;

    // default package access constructor
    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    @Override
    public String toString() { return s; }

}
