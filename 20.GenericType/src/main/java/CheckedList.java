import typeinfo.pets.Cat;
import typeinfo.pets.Dog;
import typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author denglitong
 * @date 2021/1/20
 */
public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1);

        List<Dog> dogs2 = Collections.checkedList(
                new ArrayList<>(), Dog.class);
        try {
            oldStyleMethod(dogs2);
        } catch (Exception e) {
            // Expected: java.lang.ClassCastException:
            // Attempt to insert class typeinfo.pets.Cat element into collection
            // with element type class typeinfo.pets.Dog
            System.out.println("Expected: " + e);
        }

        // Derived types work fine:
        List<Pet> pets = Collections.checkedList(
                new ArrayList<>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
