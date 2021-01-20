import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author denglitong
 * @date 2021/1/17
 */
public class RandomList<T> extends ArrayList<T> {
    private Random rand = new Random(47);

    public T select() {
        return get(rand.nextInt(size()));
    }

    public static void main(String[] args) {
        RandomList rs = new RandomList();
        Arrays.asList("The quick brown fox jumped over lazy brown dog".split(" "))
                .forEach(rs::add);
        IntStream.range(0, 11)
                .forEach(i -> System.out.print(rs.select() + " "));
    }
}
