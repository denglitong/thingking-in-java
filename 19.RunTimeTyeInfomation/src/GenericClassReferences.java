/**
 * @author denglitong
 * @date 2021/1/17
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        intClass = double.class;

        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        // genericIntClass = double.class; // 非法

        // 非法：Integer extend Number，但是 Integer.class 并不继承 Number.class
        // Class<Number> genericeNumberClass = int.class;

        // 通配符，使用 Class<?> 比使用 Class 要好，单纯使用 Class 不会产生编译警告信息
        Class<?> clazz = int.class;
        clazz = double.class;

        // 范围限定
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}
