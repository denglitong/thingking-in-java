import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author denglitong
 * @date 2021/1/13
 */
public class PathInfo {
    static void show(String id, Object p) {
        System.out.println(id + ": " + p);
    }

    static void info(Path path) {
        show("toString", path);
        show("Exists", Files.exists(path));
        show("RegularFile", Files.isRegularFile(path));
        show("Directory", Files.isDirectory(path));
        show("Absolute", path.isAbsolute());
        show("FileName", path.getFileName());
        show("Parent", path.getParent());
        show("Root", path.getRoot());
        System.out.println("******************");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        // /Users/leon/tmp/docker_prune.log
        info(Paths.get("/Users", "leon", "tmp", "docker_prune.log"));

        Path path = Paths.get("PathInfo.java");
        info(path);
        Path ap = path.toAbsolutePath();
        info(ap);
        info(ap.getParent());
        try {
            info(path.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }

        URI uri = path.toUri();
        System.out.println("URI: " + uri);
        Path pathUri = Paths.get(uri);
        System.out.println(Files.exists(pathUri));
    }
}
