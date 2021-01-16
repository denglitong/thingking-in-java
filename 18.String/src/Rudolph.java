/**
 * Unchained melody
 * My heart will go on
 * I will always love you
 * Say you say me
 * Don't cry
 *
 * @author denglitong
 * @date 2021/1/15
 */
public class Rudolph {
    public static void main(String[] args) {
        for (String pattern : new String[]{
                "Rudolph",
                "[rR]udolph",
                "[rR][aeiou][a-z]ol.*",
                "R.*"
        }) {
            System.out.println("Rudolph".matches(pattern));
        }
    }
}
