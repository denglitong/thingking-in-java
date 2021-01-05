/**
 * @autor denglitong
 * @date 2019/9/13
 */
class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}

public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {
                // 这种情况下，lm.f() 抛出的异常将被 lm.dispose() 抛出的异常所替代
                // 这是相当严重的缺陷，因为异常可能会以一种更微妙和更难以察觉的方式完全丢失
                // 相比之下，C++吧"前一个异常还没处理就抛出下一个异常"的情形是糟糕的编程错误
                // 也许在Java的未来版本中会修正这个问题
                // 另一方面，要把所有抛出异常的方法全部打包放到try-catch字句中
                // 当然一种简单的丢失异常的方式就是直接从 finally 字句中返回
                lm.dispose();
            }
        } catch (VeryImportantException | HoHumException e) {
            System.out.println(e);
        }
    }
}
