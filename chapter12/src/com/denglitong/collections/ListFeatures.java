package com.denglitong.collections;

import java.util.*;

/**
 * 基本的ArrayList，擅长随机访问元素，但在List中间插入和删除元素时速度较慢
 * LinkedList，它通过代价较低的在List中间进行的插入和删除操作，提供了优化的顺序访问，但它对于随机访问来说相对较慢
 * 除此之外LinkedList比ArrayList有更大的特征集
 *
 * @autor denglitong
 * @date 2019/8/17
 */

class Pet implements Comparable<Pet> {
    int id = 0;
    String name;

    {
        id = new Random(47).nextInt(30);
    }

    Pet() {}

    public Pet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet";
    }

    @Override
    public int compareTo(Pet o) {
        return this.toString().compareTo(o.toString());
    }
}
class Hamster extends Pet {
    @Override
    public String toString() {
        return "Hamster";
    }
}
class Cymric extends Pet {
    public Cymric() {}
    public Cymric(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Cymric";
    }
}
class Mouse extends Pet {
    @Override
    public String toString() {
        return "Mouse";
    }
}
class Rat extends Pet {
    @Override
    public String toString() {
        return "Rat";
    }
}
class Manx extends Pet {
    @Override
    public String toString() {
        return "Manx";
    }
}
class Mutt extends Pet {
    public Mutt() {}
    public Mutt(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return "Mutt";
    }
}
class Pug extends Pet {
    @Override
    public String toString() {
        return "Pug";
    }
}
class Cat extends Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat[" + name + "]";
    }
}
class Dog extends Pet {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog[" + name + "]";
    }
}

class Pets {
    static List<Pet> list(int s) {
        List<Pet> pets = new ArrayList<>();
        Random rand = new Random(new Date().getTime());
        for (int i = 0; i < s; i++) {
            switch (rand.nextInt(6)) {
                case 0:
                    pets.add(new Hamster());
                    break;
                case 1:
                    pets.add(new Cymric());
                    break;
                case 2:
                    pets.add(new Mouse());
                    break;
                case 3:
                    pets.add(new Rat());
                    break;
                case 4:
                    pets.add(new Manx());
                    break;
                case 5:
                    pets.add(new Mutt());
                    break;
                case 6:
                    pets.add(new Pug());
                default:
                    System.out.println("outbound");
            }
        }
        return pets;
    }

    static Pet get() {
        Random rand = new Random(new Date().getTime());
        switch (rand.nextInt(6)) {
            case 0:
                return new Hamster();
            case 1:
                return new Cymric();
            case 2:
                return new Mouse();
            case 3:
                return new Rat();
            case 4:
                return new Manx();
            case 5:
                return new Mutt();
            case 6:
                return new Pug();
        }
        return new Pet();
    }
}

public class ListFeatures {
    public static void main(String[] args) {
        List<Pet> pets = Pets.list(7);
        System.out.println("1: " + pets);

        Hamster h = new Hamster();
        pets.add(h);
        System.out.println("2: " + pets);
        System.out.println("3: " + pets.contains(h));
        System.out.println("4 " + pets.indexOf(h)); // always 7, that's exactly that object, not the one which same type before in List
        pets.remove(h);
        System.out.println(pets);
        System.out.println(pets.contains(h));

        Pet p = pets.get(2);
        System.out.println("4: " + p + " " + pets.indexOf(p));

        Pet cymric = new Cymric();
        System.out.println("5: " + pets.indexOf(cymric)); // -1
        System.out.println("6: " + pets.remove(cymric)); // false, must be the exact object:
        System.out.println("7: " + pets.remove(p));
        System.out.println("8: " + pets);

        // insert at an index
        pets.add(3, new Mouse());
        System.out.println("9: " + pets);

        List<Pet> sub = pets.subList(1, 4);
        System.out.println("10: " + pets.containsAll(sub));
        // order is not important in containsAll
        // Collections.sort(sub);

        Random rand = new Random(47);
        Collections.shuffle(sub, rand); // Mix it up
        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + pets.containsAll(sub));

        List<Pet> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);

        copy = new ArrayList<>(pets);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub); // only removes exact objects
        System.out.println("15: " + copy);
        copy.set(1, new Mouse());
        System.out.println("16: " + copy);
        copy.addAll(2, sub); // insert a list in the middle
        System.out.println("17: " + copy);
        System.out.println("18: " + copy.isEmpty());
        pets.clear(); // remove all elements
        System.out.println("19: " + pets);
        System.out.println("20: " + pets.isEmpty());
        pets.addAll(Pets.list(4));
        System.out.println("21: " + pets);
        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);
        Pet[] pa = pets.toArray(new Pet[0]);
        System.out.println("23: " + pa[3].id);
    }
}
