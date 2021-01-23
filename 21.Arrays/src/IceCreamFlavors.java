import java.util.SplittableRandom;

/**
 * @author denglitong
 * @date 2021/1/21
 */
public class IceCreamFlavors {
    private static SplittableRandom rand = new SplittableRandom(47);

    static final String[] FLAVORS = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };

    // 返回数组实际返回的是引用，数组在哪里创建和使用无关紧要，GC 会负责收集
    public static String[] flavorSet(int n) {
        if (n > FLAVORS.length) {
            throw new IllegalArgumentException("Set too big");
        }
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = rand.nextInt(FLAVORS.length);
            } while (picked[t]);
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            ArrayShow.show(flavorSet(3));
        }
    }
}
