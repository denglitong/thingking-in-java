/**
 * @author denglitong
 * @date 2021/1/30
 */
public @interface Uniqueness {
    // 给嵌套 annotation 指定默认值
    Constraints constrains() default @Constraints(unique = true);
}
