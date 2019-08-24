package com.denglitong.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @autor denglitong
 * @date 2019/8/23
 */
public class ForInCollections {
    public static void main(String[] args) {
        Collection<String> cs = new LinkedList<>();
        Collections.addAll(cs, "Take the long way home".split(" "));
        for (String s : cs) {
            System.out.print("'" + s + "' ");
        }
        System.out.println();
    }
}
