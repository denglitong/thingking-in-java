package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/16 20:58
 */
public class InitValidate {
    private int i;
    private char c;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public static void main(String[] args) {
        InitValidate initValidate = new InitValidate();
        System.out.println(initValidate.getI()); // 0
        System.out.println(initValidate.getC()); // [] (byte[])
    }
}
