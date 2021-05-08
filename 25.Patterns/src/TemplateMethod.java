import java.util.stream.IntStream;

/**
 * 模板方法模式：模板方法隐藏在底层，通过调用基类中的各种方法来驱动应用程序
 *
 * @author litong.deng@foxmail.com
 * @date 2021/5/6
 */
abstract class ApplicationFramework {

    public ApplicationFramework() {
        templateMethod();
    }

    abstract void customize1();
    abstract void customize2();

    // "private" means automatically "final"
    private void templateMethod() {
        IntStream.range(0, 5).forEach(n -> {
            customize1();
            customize2();
        });
    }
}

class MyApp extends ApplicationFramework {
    @Override
    void customize1() {
        System.out.print("Hello ");
    }

    @Override
    void customize2() {
        System.out.println("World!");
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        new MyApp();
    }
}
