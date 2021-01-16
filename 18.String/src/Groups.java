import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author denglitong
 * @date 2021/1/15
 */
public class Groups {
    public static final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        // (?m) 是序列开头的模式标记，告诉匹配器注意序列中的换行符（使得$可以匹配行尾可能的多个换行符）
        Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$")
                .matcher(POEM);
        while (m.find()) {
            for (int i = 0; i < m.groupCount(); i++) {
                System.out.print("[" + m.group() + "]");
            }
            System.out.println();
        }
    }
}
