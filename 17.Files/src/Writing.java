import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 * @author denglitong
 * @date 2021/1/14
 */
public class Writing {
    // 47 => '/'
    static Random rand = new Random(47);
    static final int SIZE = 1000;

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[SIZE];
        rand.nextBytes(bytes);
        Path p = Paths.get("test", "bytes.dat");
        // write bytes to a file
        Files.write(p, bytes);
        System.out.println("bytes.dat: " + Files.size(p));

        List<String> lines = Files.readAllLines(
                Paths.get("test", "Cheese.dat"));
        Path p2 = Paths.get("test", "Cheese2.txt");
        Files.write(p2, lines);
        System.out.println("Cheese2.txt: " + Files.size(p2));
    }
}
