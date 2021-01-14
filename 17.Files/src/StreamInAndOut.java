import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author denglitong
 * @date 2021/1/14
 */
public class StreamInAndOut {
    public static void main(String[] args) {
        Path p = Paths.get("")
                .resolve("17.Files")
                .resolve("src")
                .resolve("StreamInAndOut.java");

        try (
                Stream<String> input = Files.lines(p);
                PrintWriter output = new PrintWriter("StreamInAndOut.txt");
        ) {
            input.map(String::toUpperCase)
                    .forEachOrdered(output::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
