package com.denglitong.functional;

/**
 * @autor denglitong
 * @date 2019/8/24
 */
interface Description {
    String brief();
}

interface Body {
    String detailed(String head);
}

interface Multi {
    String twoArg(String head, Double d);
}

public class LambdaExpressions {
    // 单行lambda表达式的结果自动成为Lambda表达式的返回值，此时return关键字是非法的
    static Body bod = h -> h + " No Parents!";
    // 当只有一个参数可以不需要括号()
    static Body bod2 = (h) -> h + " More details";
    // 如果没有参数则必须使用括号()表示空参数列表
    static Description desc = () -> "Short info";
    // 多参数则必须将将参数包括在()中
    static Multi mult = (h, n) -> h + " " + n;
    // 确实需要多行的时候，就需要使用return
    static Description moreLines = () -> {
        System.out.println("moreLines");
        return "from moreLines";
    };

    public static void main(String[] args) {
        System.out.println(bod.detailed("Oh!"));
        System.out.println(bod2.detailed("Hi!"));
        System.out.println(desc.brief());
        System.out.println(mult.twoArg("Pi!", 3.14159));
        System.out.println(moreLines.brief());
    }
}
