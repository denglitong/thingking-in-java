import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author denglitong
 * @date 2021/1/16
 */
public class ReplacingStringTokenizer {
    public static void main(String[] args) {
        String input = "But I'm not dead yet! I feel happy!";
        // 老版本的实现方式，现已可以废弃不用了
        StringTokenizer stoke = new StringTokenizer(input);
        while (stoke.hasMoreElements()) {
            System.out.print(stoke.nextElement() + " ");
        }
        System.out.println();

        System.out.println(Arrays.toString(input.split(" ")));
        // 推荐使用 Scanner 方式
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            System.out.print(scanner.next() + " ");
        }
    }
}
