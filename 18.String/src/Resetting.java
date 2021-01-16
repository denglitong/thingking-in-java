import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author denglitong
 * @date 2021/1/16
 */
public class Resetting {
    public static void main(String[] args) {
        Matcher m = Pattern.compile("[frb][aiu][gx]")
                .matcher("fix the rug with bags");
        while (m.find()) {
            System.out.print(m.group() + " ");
        }
        System.out.println();
        // reset() 不带参数版本可将 m 重置到当前字符序列的起始位置
        m.reset("fix the rig with rags");
        while (m.find()) {
            System.out.print(m.group() + " ");
        }
    }
}
