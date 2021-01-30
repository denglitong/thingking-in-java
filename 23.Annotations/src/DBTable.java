import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author denglitong
 * @date 2021/1/29
 */
@Target({ElementType.TYPE, ElementType.FIELD}) // Target 可应用多个类型，用逗号分隔
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    String name() default "";
}
