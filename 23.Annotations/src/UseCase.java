import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解看起来像一个空接口
 * 注解的定义也需要一些元注解
 * 注解通常包含一些表示特定值的元素，看起来就像是接口的方法
 * 不包含任何元素的注解称为标记注解
 *
 * @author denglitong
 * @date 2021/1/24
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    // 注解可用的类型有：
    // 所有基本类型（int, float, boolean 等）
    // String, Class, enum, Annotation
    // 以上类型的数组类型
    // 注解可以嵌套

    // 元素要么有默认值，要么在使用时传值，不能有不确定的值
    int id() default -1;
    // 非基本类型的元素默认值都不能使用 null，因为不能区分缺失和默认
    String description() default "no description";
}
