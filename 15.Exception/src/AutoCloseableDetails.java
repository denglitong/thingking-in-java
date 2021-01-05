/**
 * @autor denglitong
 * @date 2019/9/13
 */
class Reporter implements AutoCloseable {
    String name = getClass().getSimpleName();
    public Reporter() {
        System.out.println("Creating " + name);
    }

    @Override
    public void close() {
        System.out.println("Closing " + name);
    }
}

class First extends Reporter {}
class Second extends Reporter {}

public class AutoCloseableDetails {
    public static void main(String[] args) {
        try (
                First f = new First();
                Second s = new Second();
        ) {
            //
        }
        // 退出 try 快会调用2个对象的 close() 方法，并以创建顺序相反的顺序关闭他们，
        // 顺序很重要，这是因为如果关闭顺序不当可能会造成错误，比如存在相互依赖的情况
    }
}
