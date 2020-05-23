package com.denglitong.validating;

import java.util.ArrayList;

/**
 * @autor denglitong
 * @date 2019/9/14
 */
public class CountedList extends ArrayList<String> {
    private static int counter = 0;
    private int id = counter++;
    public CountedList() {
        System.out.println("CountedList #" + id);
    }
    public int getId() {
        return id;
    }
}
