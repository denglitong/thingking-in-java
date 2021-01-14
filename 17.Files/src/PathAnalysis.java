import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author denglitong
 * @date 2021/1/13
 */
public class PathAnalysis {
    static void say(String id, Object result) {
        System.out.println(id + ": " + result);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("os.name"));
        String pstr = "/Users/leon/projects/programmings/java/thingking-in-java/17.Files/src/PathAnalysis.java";
        Path p = Paths.get(pstr).toAbsolutePath();
        say("Exists", Files.exists(p));
        say("Directory", Files.isDirectory(p));
        say("Executable", Files.isExecutable(p));
        say("Readable", Files.isReadable(p));
        say("RegularFile", Files.isRegularFile(p));
        say("Writable", Files.isWritable(p));
        say("notExists", Files.notExists(p));
        say("hidden", Files.isHidden(p));
        say("size", Files.size(p));
        say("FileStore", Files.getFileStore(p));
        say("LastModified", Files.getLastModifiedTime(p));
        say("Owner", Files.getOwner(p));
        say("ContentType", Files.probeContentType(p));
        say("SymbolicLink", Files.isSymbolicLink(p));
        if (Files.isSymbolicLink(p)) {
            say("SymbolicLink", Files.readSymbolicLink(p));
        }
        // 测试当前稳健性桐是否支持 posix 接口
        if (FileSystems.getDefault().supportedFileAttributeViews().contains("posix")) {
            say("PosixFilePermissions", Files.getPosixFilePermissions(p));
        }
    }
}
