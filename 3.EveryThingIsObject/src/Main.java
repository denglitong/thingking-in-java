import java.util.Arrays;
import java.util.Date;

/**
 * @autor denglitong
 * @date 2019/7/15 15:04
 */
public class Main {

    private static int i = 0;
    public static int j = 1;

    static int k = 2;

    public static void main(String[] args) {
        say(1);
        say(1,2);
        say(1,2,3);

        // there is no public/private diff for static column
        System.out.println(Main.i);
        System.out.println(Main.j);
        System.out.println(Main.k);

        System.out.println("Hello, it's: " + new Date());
    }

    public static void say(int... args) {
        System.out.println(Arrays.toString(args));
    }
}
