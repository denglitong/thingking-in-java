package com.denglitong.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @autor denglitong
 * @date 2019/8/18
 */
public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random(47);
        // 不用使用基本类型的集合
        // 这是因在底层存储的时候都是Map<Object, Object>
        // 所以具体的类型在实现的时候都是判断添加/查询的值是否是声明时候的类型
        // 而为了通用的原因就需要要求所传入的类型要有一个共同的实现来判断其类型，所以不能使用基本类型而是需要使用封装类型
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(m);
    }
}
