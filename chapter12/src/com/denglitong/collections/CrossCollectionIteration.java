package com.denglitong.collections;

import java.util.*;

/**
 * @autor denglitong
 * @date 2019/8/18
 */
public class CrossCollectionIteration {
    // 迭代器不好吧有关它遍历的序列的类型信息
    // 迭代器统一了对集合的访问方式
    public static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id + ":" + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> pets = Pets.list(8);
        LinkedList<Pet> pets1 = new LinkedList<>(pets);
        HashSet<Pet> pets2 = new HashSet<>(pets);
        TreeSet<Pet> pets3 = new TreeSet<>(pets);
        display(pets.iterator());
        display(pets1.iterator());
        display(pets2.iterator());
        display(pets3.iterator());
    }
}
