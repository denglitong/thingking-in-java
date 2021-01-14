import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

/**
 * @author denglitong
 * @date 2021/1/14
 */
public class TreeWatcher {
    static void watchDir(Path dir) {
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            dir.register(watcher, ENTRY_DELETE);
            Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    WatchKey key = watcher.take();
                    for (WatchEvent<?> evt : key.pollEvents()) {
                        System.out.println("evt.context(): " + evt.context() +
                                "\next.count(): " + evt.count() +
                                "\next.kind(): " + evt.kind());
                        System.exit(0);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Directories.refreshTestDir();
        Directories.populateTestDir();

        Files.walk(Paths.get("test"))
                .filter(Files::isDirectory)
                .forEach(TreeWatcher::watchDir);

        PathWatcher.delTxtFiles();
    }
}
