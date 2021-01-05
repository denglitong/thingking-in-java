import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @autor denglitong
 * @date 2019/9/7
 */
class Pair {
    public final Character c;
    public final Integer i;
    public Pair(Character c, Integer i) {
        this.c = c;
        this.i = i;
    }
    public Character getC() {
        return c;
    }
    public Integer getI() {
        return i;
    }
    @Override
    public String toString() {
        return "Pair(" + c + "," + i + ")";
    }
}

class RandomPair {
    Random rand = new Random(47);
    // 创建一个流并返回它的iterator，这样它可以在别的流中使用
    // 这是组合多个流以生成新的流的唯一方法
    Iterator<Character> capChars = rand.ints(65, 91)
            .mapToObj(i -> (char)i)
            .iterator();

    public Stream<Pair> stream() {
        return rand.ints(100, 1000)
                .distinct()
                .mapToObj(i -> new Pair(capChars.next(), i));
    }
}

public class MapCollector {
    public static void main(String[] args) {
        Map<Integer, Character> map = new RandomPair().stream()
                .limit(8)
                .collect(Collectors.toMap(Pair::getI, Pair::getC));
        System.out.println(map);
    }
}
