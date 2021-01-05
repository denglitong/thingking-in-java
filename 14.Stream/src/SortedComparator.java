import java.util.Comparator;

/**
 * @autor denglitong
 * @date 2019/8/31
 */
public class SortedComparator {
    public static void main(String[] args) throws Exception {
        String filePath = "/Users/leon/javaspace/thingking-in-java/chapter14/src/Cheese.dat";
        FileToWords.stream(filePath)
                .skip(10)
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
