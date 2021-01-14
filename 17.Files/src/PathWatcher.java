import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author denglitong
 * @date 2021/1/14
 */
public class PathWatcher {
    static Path test = Paths.get("test");

    static void delTxtFiles() {
        try {
            Files.walk(test)
                    .filter(f -> f.toString().endsWith(".txt"))
                    .forEach(f -> {
                        System.out.println("deleting " + f);
                        try {
                            Files.delete(f);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.createFile(test.resolve("Hello.txt"));

        WatchService watcher = FileSystems.getDefault().newWatchService();
        test.register(watcher, StandardWatchEventKinds.ENTRY_DELETE);

        Executors.newSingleThreadScheduledExecutor()
                .schedule(PathWatcher::delTxtFiles, 250, TimeUnit.MICROSECONDS);

        WatchKey key = watcher.take();
        for (WatchEvent<?> evt : key.pollEvents()) {
            System.out.println("evt.context(): " + evt.context() +
                    "\next.count(): " + evt.count() +
                    "\next.kind(): " + evt.kind());
            System.exit(0);
        }
    }
}
