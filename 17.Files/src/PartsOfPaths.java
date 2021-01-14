import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author denglitong
 * @date 2021/1/13
 */
public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("PartsOfPaths.java").toAbsolutePath();
        for (int i = 0; i < p.getNameCount(); i++) {
            // getName(i) 返回 Path 路径里分隔符隔开的各个部分的名称
            // /path/to/dir/file.ext -> [path, to, dir, file.ext]，注意没有包含跟路径
            System.out.print(p.getName(i) + " ");
        }
        System.out.println();
        // [..., filename.ext] 不会匹配 '.ext'
        System.out.println("ends with '.java': " + p.endsWith(".java"));

        // 这里 iterate 的其实是 p.getName(i)
        for (Path pp : p) {
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp));
        }

        System.out.println("Starts with " + p.getRoot() + " " +
                p.startsWith(p.getRoot()));
    }
}
