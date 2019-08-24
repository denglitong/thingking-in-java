package com.denglitong.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @autor denglitong
 * @date 2019/8/19
 */

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person[" + name + "]";
    }
}

public class MapOfList {
    public static final Map<Person, List<? extends Pet>> petPeople = new HashMap<>();

    static {
        petPeople.put(new Person("Dawn"), Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
        petPeople.put(new Person("Kate"), Arrays.asList(new Cat("Shackleton"), new Dog("Margrett")));
    }

    public static void main(String[] args) {
        System.out.println("People: " + petPeople.keySet());
        System.out.println("Pets: " + petPeople.values());
        for (Person person : petPeople.keySet()) {
            System.out.println(person + " has: ");
            for (Pet pet : petPeople.get(person)) {
                System.out.println("\t" + pet);
            }
        }
    }
}
