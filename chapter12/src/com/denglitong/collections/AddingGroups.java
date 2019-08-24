package com.denglitong.collections;

import java.util.*;

/**
 * @autor denglitong
 * @date 2019/8/17
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts = {6,7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));
        // addAll 运行速度更快，这是首选的方式初始化一个collection
        Collections.addAll(collection, 11,12,13,14,15);
        Collections.addAll(collection, moreInts);
        System.out.println(collection);
        // Arrays.asList底层实现是数组，没法调整大小
        List<Integer> list = Arrays.asList(16,17,18,19,20);
        list.set(1,99);
        System.out.println(list);
        // list.add(21); // UnsupportedOperationException the underlying array cannot be resized
    }
}
