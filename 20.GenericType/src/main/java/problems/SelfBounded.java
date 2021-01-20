package problems;

/**
 * 这里的 extends 强调的是边界，与用来创建子类是明显不同的
 *
 * @author denglitong
 * @date 2021/1/20
 */
public class SelfBounded<T extends SelfBounded2<T>> {
}
