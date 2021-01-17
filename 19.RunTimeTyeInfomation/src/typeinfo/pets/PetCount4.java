package typeinfo.pets;

/**
 * @author denglitong
 * @date 2021/1/17
 */
public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        Pets.stream()
                .limit(20)
                .peek(counter::count)
                .forEach(p -> System.out.print(
                        p.getClass().getSimpleName() + " "));
        System.out.println("\n" + counter);
    }
}
