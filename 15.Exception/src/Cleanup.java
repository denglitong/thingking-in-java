/**
 * 对于在构造阶段可能会抛出异常，并且要求清理的类，
 * 最安全的使用方式是使用嵌套的 try 字句
 *
 * @autor denglitong
 * @date 2019/9/13
 */
public class Cleanup {
    public static void main(String[] args) {
        try {
            // 如果 InputFile 构造失败，将进入外部的 catch 字句，而 dispose() 方法不会被调用
            // 但是如果构造成功，我们肯定想确保对象能够被清理，因此在构造之后即立即创建了一个新的 try 语句块
            // 执行清理的 finally 与内部的 try 关联
            // 在这种方式中，finally字句在构造失败是是不会执行的，而在构造成功时总是执行
            //
            // 这种通用的清理惯用法在构造器不抛出任何异常类型时也应该运用，其基本规则是：
            // 在创建需要清理的对象之后，立即进入一个 try-finally 语句块
            InputFile in = new InputFile("Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null) {
                    // perform line-by-line processing here...
                }
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
            } finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("InputFile construction failed");
        }
    }
}
