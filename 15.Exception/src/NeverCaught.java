/**
 * 如果 RuntimeException 没有被捕获而直达 main()，
 * 那么在程序退出前将调用异常的 printStackTrace() 方法
 * <p>
 * RuntimeException及其子类是一个特例，对于这种异常类型，
 * * 编译器不需要异常说明，其输出被报告给了 System.err
 * </>
 * <p>
 * 请务必记住：只能在代码中胡磊 RuntimeException及其子类的异常，
 * 因为所有接受检查类型异常的处理都是由编译器强制实施的
 * </p>
 *
 * @autor denglitong
 * @date 2019/9/13
 */
class SpecificException extends Throwable {}

public class NeverCaught {
    static void f() {
        throw new RuntimeException("From f()");
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }
}
