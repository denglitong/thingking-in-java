package com.denglitong.hiding;

/**
 * @autor denglitong
 * @date 2019/7/24
 */
public class Soup2 {

    private Soup2() {}

    // singleton
    private static Soup2 ps1 = new Soup2();

    public static Soup2 access() {
        return ps1;
    }

    public void f() {}

}
