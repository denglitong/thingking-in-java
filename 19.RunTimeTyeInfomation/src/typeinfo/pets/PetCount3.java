package typeinfo.pets;

import javafx.util.Pair;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * @author denglitong
 * @date 2021/1/17
 */
public class PetCount3 {
    static class Counter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        public Counter() {
            super(LiteralPetCreator.ALL_TYPES.stream()
                    .map(lpc -> new Pair<>(lpc, 0))
                    .collect(Collectors.toMap(Pair::getKey, Pair::getValue)));
        }

        public void count(Pet pet) {
            entrySet().stream()
                    .filter(pair -> pair.getKey().isInstance(pet))
                    .forEach(pair -> put(pair.getKey(), pair.getValue() + 1));
        }

        @Override
        public String toString() {
            String result = entrySet().stream()
                    .map(pair -> String.format("%s=%s",
                            pair.getKey().getSimpleName(),
                            pair.getValue()))
                    .collect(Collectors.joining(", "));
            return "{ " + result + " }";
        }

        public static void main(String[] args) {
            Counter petCount = new Counter();
            Pets.stream()
                    .limit(20)
                    .peek(petCount::count)
                    .forEach(p -> System.out.print(
                            p.getClass().getSimpleName() + " "));
            System.out.println("\n" + petCount);
        }
    }
}
