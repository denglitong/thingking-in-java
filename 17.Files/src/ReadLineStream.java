import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author denglitong
 * @date 2021/1/14
 */
public class ReadLineStream {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("")
                .resolve("17.Files")
                .resolve("src")
                .resolve("TreeWatcher.java");

        Files.lines(p)
                .skip(10)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
