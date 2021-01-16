import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author denglitong
 * @date 2021/1/15
 */
public class TheReplacements {
    public static void main(String[] args) {
        String s = "/*! Here's a block of text to use as input to \n" +
                "    the regular expression matcher. Note that we \n" +
                "    first extract the block of text by looking for \n" +
                "    the special delimiters, then process the     \n" +
                "    extracted block. !*/";

        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL)
                .matcher(s);
        if (mInput.find()) {
            s = mInput.group(1);
        }
        s = s.replaceAll(" {2,}", " ");
        s = s.replaceAll("(?m)^ +", "");
        System.out.println(s);

        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        System.out.println(s);
        System.out.println("*********");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        while (m.find()) {
            // 在 s 的基础上，对于 m find 到的部分替换为 replacement
            // 然后把当前匹配到的部分追加到 sbuf 里面
            m.appendReplacement(sbuf, m.group().toUpperCase());
        }
        m.appendTail(sbuf);
        System.out.println(sbuf.toString());
    }
}
