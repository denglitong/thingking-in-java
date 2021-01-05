import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * try() 括号内的部分称为资源规范头 resource specification header
 * 重要的是，无论你如何退出 try 快，都会执行前对资源的判断释放操作
 * try-with-resources 定义字句中创建的对象必须实现 java.lang.AutoCloseable 接口
 * 这个接口有一个 close()
 * 当在 Java7 中引入 AutoCloseable 时，许多接口和类被修改以实现它，其中包括 Stream 对象
 *
 * @autor denglitong
 * @date 2019/9/13
 */
public class TryWithResources {
    public static void main(String[] args) {
        try (
                InputStream in = new FileInputStream(new File("TryWithResources.java"))
        ) {
            int contents = in.read();
        } catch (IOException e) {
            // handle the error
            e.printStackTrace();
        }
    }
}
