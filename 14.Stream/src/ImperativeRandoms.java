import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class ImperativeRandoms {
    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Integer> rints = new TreeSet<>();
        // 外部迭代
        while (rints.size() < 7) {
            int r = rand.nextInt(20);
            if (r < 5) {
                continue;
            }
            rints.add(r);
        }
        System.out.println(rints);
    }
}
