/**
 * 5 个标准注解
 *
 * @Override
 * @Deprecated
 * @SuppressWarnings
 * @SafeVarags
 * @FunctionalInterface <p>
 * <p>
 * 5 种元注解
 * @Target 表示注解可用于哪些地方
 * CONSTRUCTOR FIELD LOCAL_VARIABLES METHOD PACKAGE PARAMETER TYPE（类、接口、enum）
 * @Retention 表示注解信息保存的时长
 * SOURCE(注解将被编译器丢弃)
 * CLASS（注解在 class 文件中可用，但是会被 VM 丢弃）
 * RUNTIME（VM 将在运行期也保留注解，因此可通过反射机制读取）
 */
public class Testable {
    public void execute() {
        System.out.println("Executing...");
    }

    @Test
    void testExecute() {
        execute();
    }
}
