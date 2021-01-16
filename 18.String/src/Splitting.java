import java.util.Arrays;

/**
 * @author denglitong
 * @date 2021/1/15
 */
public class Splitting {
    public static String knights =
            "Then, when you have found the shrubbery, " +
                    "you must cut down the mightiest tree in the " +
                    "forest...with... a herring!";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+"); // split by non-word characters(the result is words)
        split("\\w+"); // split by word characters(the result is non-words)
        split("n\\W+");
    }
}
