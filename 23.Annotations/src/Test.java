import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author denglitong
 * @date 2021/1/24
 */
// @Target 定义你的注解可以应用在哪里（类、方法、字段）
@Target(ElementType.METHOD)
// @Retention 定义了注解在哪里可用（源代码中（SOURCE）, class 文件（CLASS），运行时（RUNTIME））
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
}
