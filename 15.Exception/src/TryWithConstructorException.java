/**
 * @autor denglitong
 * @date 2019/9/13
 */
class CE extends Exception {}
class SecondExcept extends Reporter {
    public SecondExcept() throws CE {
        super();
        throw new CE();
    }
}
class Third extends Reporter {}

public class TryWithConstructorException {
    public static void main(String[] args) {
        // 构造器在 try() 中抛出异常，在 catch 中捕获
        try (
                First f = new First();
                SecondExcept s = new SecondExcept();
                Second s2 = new Second();
        ) {
            System.out.println("In body");
        } catch (CE e) {
            System.out.println("Caught: " + e);
        }

        System.out.println("======");

        // try() 资源规范中没有跑异常，但是如果在 body 中抛异常了，
        // 还是要在 catch 语句块中捕获
        try (
                First f = new First();
                Second s2 = new Second();
        ) {
            System.out.println("In body");
            // 请注意，此处该对象用于不会被清除，那是因为它不是在资源规范头中创建的
            // 所以它没有被保护，这很重要
            // 因为 Java 在这里没有以警告或错误的形式提供指导，因此像这样的错误很容易漏掉
            // try-with-resource 的特性通常只会保护他们遇到的第一个对象而忽略其余的对象
            Third t = new Third();
            new SecondExcept();
            System.out.println("End of body");
        } catch (CE e) {
            System.out.println("Caught: " + e);
        }
    }
}
