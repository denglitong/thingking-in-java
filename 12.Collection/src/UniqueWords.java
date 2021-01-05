import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @autor denglitong
 * @date 2019/8/18
 */
public class UniqueWords {
    public static void main(String[] args) throws Exception {
        String dir = "/Users/leon/javaspace/thingking-in-java/chapter12/src/com/denglitong/collections";
        List<String> lines = Files.readAllLines(Paths.get(dir + "/SetOperations.java"));
        Set<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        for (String line : lines) {
            for (String word : line.split("\\W+")) {
                if (word.trim().length() <= 0) {
                    continue;
                }
                words.add(word);
            }
        }
        System.out.println(words);
    }
}
