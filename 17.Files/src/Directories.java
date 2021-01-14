import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author denglitong
 * @date 2021/1/13
 */
public class Directories {
    static Path test = Paths.get("test");
    static String sep = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");

    static Path makeVariant() {
        Collections.rotate(parts, 1);
        return Paths.get("test", String.join(sep, parts));
    }

    static void refreshTestDir() throws Exception {
        if (Files.exists(test)) {
            RmDir.rmdir(test);
        }
        if (!Files.exists(test)) {
            Files.createDirectory(test);
        }
    }

    public static void main(String[] args) throws Exception {
        refreshTestDir();
        Files.createFile(test.resolve("Hello.txt"));

        Path variant = makeVariant();
        try {
            // createDirectory() 只能创建单级目录
            Files.createDirectory(variant);
        } catch (Exception e) {
            System.out.println("Nope, that doesn't work.");
        }

        populateTestDir();

        Path tempdir = Files.createTempDirectory(test, "DIR_");
        // preXXX.non 其中 XXX 部分是随机字符串
        Files.createTempFile(tempdir, "pre", ".non");
        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println("*********");
        Files.walk(test).forEach(System.out::println);
    }

    static void populateTestDir() throws Exception {
        String pstr = "/Users/leon/projects/programmings/java/thinking-in-java/17.Files/src/Directories.java";
        for (int i = 0; i < parts.size(); i++) {
            Path variant = makeVariant();
            if (Files.notExists(variant)) {
                // 创建多级目录
                Files.createDirectories(variant);
                Files.copy(Paths.get(pstr), variant.resolve("File.txt"));
                // 未指定 suffix 会默认使用 .tmp
                Files.createTempFile(variant, null, null);
            }
        }
    }
}
