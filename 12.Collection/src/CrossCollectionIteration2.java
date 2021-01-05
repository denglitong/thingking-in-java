import java.util.*;

/**
 * @autor denglitong
 * @date 2019/8/18
 */
public class CrossCollectionIteration2 {
    // 可以产生Iterator的任何东西
    public static void display(Iterable<Pet> ip) {
        Iterator<Pet> it = ip.iterator();
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

        display(pets);
        display(pets1);
        display(pets2);
        display(pets3);
    }
}
