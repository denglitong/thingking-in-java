package com.dlt;

import static com.google.common.base.Preconditions.*;

/**
 * @author denglitong
 * @date 2020/2/8
 */
public class NonNullConstruction {
    private Integer n;
    private String s;
    public NonNullConstruction(Integer n, String s) {
        this.n = checkNotNull(n);
        this.s = checkNotNull(s);
    }

    public static void main(String[] args) {
        NonNullConstruction nnc = new NonNullConstruction(3, "Trousers");
        // nnc = new com.denglitong.NonNullConstruction(null, "Trousers");
    }
}
