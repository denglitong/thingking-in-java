import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @autor denglitong
 * @date 2019/9/13
 */
public class InputFile {
    private BufferedReader in;
    public InputFile(String fname) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fname));
            // other code that might throw exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Could not open " + fname);
            // wasn't open, so don't close it
            throw e;
        } catch (Exception e) {
            // all other exceptions must close it
            try {
                in.close();
            } catch (IOException e1) {
                System.out.println("in.close unsuccessful");
            }
            // 在构造器本地处理完之后，异常将重新抛出，这对于构造器而言这么做是很合适的
            // 因为你总不希望去遇到调用方，让他认为这个"对象以及创建完毕，可以使用了"
            // 如果用法恰当的话，直接向上层抛的确能简化编程
            throw e;
        } finally {
            // don't close it here!!! 因为 finally 快总是会被执行的
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    // 当用户不在需要 InputFile 对象是，就必须调用 dispose() 方法，这将是否 BufferedReader
    // 和 FileReader 对象所占用的系统资源（比如文件句柄），在使用完 InputFile 对象之前是不会调用它的
    // 可能你会考虑把上述功能放到 finalize() 方法里面，但是 finalize() 方法会不会被调用，
    // 完全取决于 Java GC 时候对对象所做的动作（即使被调用，也不知道在什么时候调用）
    // 这也是 Java 的缺陷，除了内存的清理之外，所有的清理都不会自动发送
    // 所以必须告诉客户端程序员，这是他们的责任
    public void dispose() {
        try {
            in.close();
            System.out.println("dispose successful");
        } catch (IOException e) {
            throw new RuntimeException("in.close() failed");
        }
    }
}
