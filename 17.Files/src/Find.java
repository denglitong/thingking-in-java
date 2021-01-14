import java.nio.file.*;

/**
 * @author denglitong
 * @date 2021/1/14
 */
public class Find {
    public static void main(String[] args) throws Exception {
        Path test = Paths.get("test");
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.createDirectory(test.resolve("dir.tmp"));

        PathMatcher matcher1 = FileSystems.getDefault()
                .getPathMatcher("glob:**/*.{tmp,txt}");
        Files.walk(test)
                .filter(matcher1::matches)
                .forEach(System.out::println);
        System.out.println("**********");

        PathMatcher matcher2 = FileSystems.getDefault()
                .getPathMatcher("glob:*.tmp");
        Files.walk(test)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
        System.out.println("*********");

        Files.walk(test)
                .filter(Files::isRegularFile) // only lock for file
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
    }
}
