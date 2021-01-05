/**
 * @autor denglitong
 * @date 2019/9/13
 */
class Anything {}

public class TryAnything {
    public static void main(String[] args) {
        // 如果 try() 并没有实现 AutoCloseable() 接口，将会出现编译时错误
        // try (
        //         // Incompatible types
        //         Anything a = new Anything();
        // ) {
        //
        // }
    }
}
