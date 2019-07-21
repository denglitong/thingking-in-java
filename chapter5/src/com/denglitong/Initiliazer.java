package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/20 20:49
 */
public class Initiliazer {

    private String str;
    private String val = "val";

    public Initiliazer() {
        System.out.println(str); // null
        System.out.println(val);
    }

    public static void main(String[] args) {
        new Initiliazer();
        new Initiliazer();
    }

}
