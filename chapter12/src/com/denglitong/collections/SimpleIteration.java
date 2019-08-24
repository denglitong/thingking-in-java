package com.denglitong.collections;

import java.util.Iterator;
import java.util.List;

/**
 * @autor denglitong
 * @date 2019/8/18
 */
public class SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.list(12);
        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id + ";" + p + " ");
        }
        System.out.println();

        // a simpler approach, when possible:
        for (Pet p : pets) {
            System.out.print(p.id + ":" + p + " ");
        }
        System.out.println();

        // an iterator can also remove elements:
        it = pets.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }
        System.out.println(pets);

        it = pets.iterator();
        // remove the next value, that's, next must be call before remove
        // it.remove(); // IllegalStateException
        // it.next();
        // it.remove();
        // it.remove(); // IllegalStateException
    }
}
