package covriant;

/**
 * @author denglitong
 * @date 2021/1/19
 */
public class NonCovariantGenerics {
    /**
     * compile error: incompatible types
     * 泛型不仅仅是关于集合，它真正要表达的是：
     * 不能把一个涉及 Apple 的泛型赋值给一个涉及 Fruit 的泛型
     * 因为类型擦除编译器无法得知类型之间的继承关系，因而拒绝向上转型从而认为是不兼容的两种 type
     *
     * 这里，集合类型和集合持有对象的类型是不同的
     */
    // List<Fruit> fruits = new ArrayList<Apple>();
}
