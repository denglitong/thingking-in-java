package com.denglitong.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
public class Closure9 {
    Supplier<List<Integer>> makeFun() {
        List<Integer> ai = new ArrayList<>();
        // 重新赋值引用就是修改了对象，这不符合lambda表达式对变量的final等价要求
        // ai = new ArrayList<>();
        return () -> ai;
    }
}
