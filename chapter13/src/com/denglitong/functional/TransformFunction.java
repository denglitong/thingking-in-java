package com.denglitong.functional;

import java.util.function.Function;

/**
 * @autor denglitong
 * @date 2019/8/25
 */
class I {
    @Override
    public String toString() {
        return "I";
    }
}

class O {
    @Override
    public String toString() {
        return "O";
    }
}

public class TransformFunction {
    // transform产生的是一个新的函数，它将in的动作与andThen参数的动作结合起来
    static Function<I, O> transform(Function<I, O> in) {
        // andThen方法专门用于操作函数
        return in.andThen(o -> {
            System.out.println(o);
            return o;
        });
    }

    public static void main(String[] args) {
        Function<I, O> f2 = transform(i -> {
            System.out.println(i);
            return new O();
        });

        O o = f2.apply(new I());
    }
}
