/**
 * 自定义异常来，必须从已有的异常类继承
 * 建立新的异常类型最简单的方法就是让编译器为你产生无参构造器
 *
 * @autor denglitong
 * @date 2019/9/8
 */
class SimpleException extends Exception {}

public class InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        }
    }
}
