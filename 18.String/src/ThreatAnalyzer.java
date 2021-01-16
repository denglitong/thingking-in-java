import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * @author denglitong
 * @date 2021/1/16
 */
public class ThreatAnalyzer {
    static String threatData =
            "58.27.82.161@08/10/2015\n" +
                    "204.45.234.40@08/11/2015\n" +
                    "58.27.82.161@08/11/2015\n" +
                    "58.27.82.161@08/12/2015\n" +
                    "58.27.82.161@08/12/2015\n" +
                    "[Next log section with different data format]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(threatData);
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" +
                "(\\d{2}/\\d{2}/\\d{4})";
        MatchResult match;
        String ip, date;
        while (scanner.hasNext(pattern)) {
            scanner.next(pattern);
            match = scanner.match();
            ip = match.group(1);
            date = match.group(2);
            System.out.printf("Threat on %s from %s%n", date, ip);
        }
    }
}
