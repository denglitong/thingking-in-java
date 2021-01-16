import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author denglitong
 * @date 2021/1/15
 */
public class Hex {
    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0) {
                result.append(String.format("%05x: ", n));
            }
            result.append(String.format("%02x ", b));
            n++;
            if (n % 16 == 0) {
                result.append("\n");
            }
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            Path p = Paths.get("out")
                    .resolve("production")
                    .resolve("18.String")
                    .resolve("Hex.class");
            System.out.println(format(Files.readAllBytes(p)));
        }
    }
}
