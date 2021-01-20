package problems;

import java.util.List;

/**
 * @author denglitong
 * @date 2021/1/20
 */
public class UseList<W, T> {
    /**
     * 因为类型擦除，重载方法产生了相同的类型签名
     * 当擦除后的参数不能参数唯一的函数签名时，你必须提供不通过的方法名
     */
    // void f(List<T> v) {}
    // void f(List<W> v) {}

    void f1(List<T> V) {}
    void f2(List<W> V) {}
}
