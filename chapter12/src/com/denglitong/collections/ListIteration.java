package com.denglitong.collections;

import java.util.List;
import java.util.ListIterator;

/**
 * @autor denglitong
 * @date 2019/8/18
 */
public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.list(8);
        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
        }
        System.out.println();

        // backwards:
        while (it.hasPrevious()) {
            System.out.print(it.previous() + ", " + it.previousIndex() + ", " + it.nextIndex() + "; ");
        }
        System.out.println();

        System.out.println(pets);
        it = pets.listIterator(3);
        while (it.hasNext()) {
            it.next();
            it.set(Pets.get());
        }
        System.out.println(pets);
    }
}
