package com.denglitong.functional;

import java.util.function.Function;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
// 使用接口，可以轻松的为专有接口创建别名
interface FuncSS extends Function<String, String> {}

public class ProduceFunction {
    // 这里的produce是高阶函数，因为它返回的是一个函数，而不是其他的基本/封装类型
    // 要传递/消费一个函数，需要在参数列表正确的描述函数类型
    static FuncSS produce() {
        // 使用Lambda表达式可以轻松的在方法中创建和返回一个函数
        return s -> s.toLowerCase();
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));
    }
}
