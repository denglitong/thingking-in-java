package com.denglitong.collections;

import java.util.*;

/**
 * @autor denglitong
 * @date 2019/8/17
 */
public class PrintingCollections {
    // collection: one element in each slot
    static Collection fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    // map: each slot contains two elements, key and value
    static Map fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<>()));
        System.out.println(fill(new LinkedList<>()));
        System.out.println();

        // HashMap使用相当复杂的方法存储元素
        System.out.println(fill(new HashSet<>()));
        // 如果存储顺序很重要，则可以使用TreeSet，它将按比较结果的圣墟来保存对象
        System.out.println(fill(new TreeSet<>()));
        // LinkedHashSet 按照被添加的先后顺序保存对象
        System.out.println(fill(new LinkedHashSet<>()));
        System.out.println();

        System.out.println(fill(new HashMap<>()));
        System.out.println(fill(new TreeMap<>()));
        System.out.println(fill(new LinkedHashMap<>()));
    }
}
