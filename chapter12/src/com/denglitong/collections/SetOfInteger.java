package com.denglitong.collections;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Set就是一个Collection，只是行为不同（这是继承和多态思想的典型应用：表现不同的行为）
 * <p>
 * 早期Java版本的HashSet产生的输出没有可辨别的顺序，这是处于对速度的追求，HashSet使用了散列
 * TreeSet将元素存储在红-黑数数据结构中
 * LinkedHashSet因为查询速度的原因也使用了散列，但是使用了链表来维护元素的插入顺序
 *
 * @autor denglitong
 * @date 2019/8/18
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            integerSet.add(rand.nextInt(30));
        }
        System.out.println(integerSet);
        System.out.println(integerSet.size());
    }
}
