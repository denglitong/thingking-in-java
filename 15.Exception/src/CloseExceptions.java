/**
 * @autor denglitong
 * @date 2019/9/13
 */
class CloseException extends Exception {}
class Reporter2 implements AutoCloseable {
    String name = getClass().getSimpleName();
    public Reporter2() {
        System.out.println("Creating " + name);
    }

    @Override
    public void close() throws CloseException {
        System.out.println("Closing " + name);
    }
}

class Closer extends Reporter2 {
    @Override
    public void close() throws CloseException {
        super.close();
        throw new CloseException();
    }
}

public class CloseExceptions {
    public static void main(String[] args) {
        // 应始终尽可能使用 try-with-resources
        // 它有助于生成的代码更清晰
        try (
                First f = new First();
                Closer c = new Closer();
                Second s = new Second();
        ) {
            System.out.println("In body");
        } catch (CloseException e) {
            System.out.println("Caught: " + e);
        }
    }
}
