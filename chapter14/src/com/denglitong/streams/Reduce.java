package com.denglitong.streams;

import java.util.Random;
import java.util.stream.Stream;

/**
 * reduce() 将流打平成单个值
 *
 * @autor denglitong
 * @date 2019/9/7
 */
class Frobnitz {
    int size;
    public Frobnitz(int size) {
        this.size = size;
    }
    @Override
    public String toString() {
        return "Frobnitz(" + size + ")";
    }
    // Generator
    static Random rand = new Random(47);
    static final int BOUND = 100;
    // supply() 函数对于 Supplier<Frobnitz> 是签名兼容的
    // 可以将其方法引用传递给 Stream.generate()
    // 这种签名兼容性被称作结构一致性
    static Frobnitz supply() {
        return new Frobnitz(rand.nextInt(BOUND));
    }
}

public class Reduce {
    public static void main(String[] args) {
        Stream.generate(Frobnitz::supply)
                .limit(10)
                .peek(System.out::println)
                // reduce() 没有提供起始值，返回的结果类型是Optional()
                // Lambda 表达式的第一个参数 fr0 是上一次调用 reduce() 的结果
                // 而第二个参数 fr1 是从流传递过来的值
                .reduce((fr0, fr1) -> fr0.size < 50 ? fr0 : fr1)
                // ifPresent() 只有在结果非空的时候才会调用 Consumer<Frobnitz>
                .ifPresent(System.out::println);
    }
}
