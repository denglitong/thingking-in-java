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
    int id();
    String description() default "no description";
}
