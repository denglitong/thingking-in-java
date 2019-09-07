package com.denglitong.streams;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @autor denglitong
 * @date 2019/9/5
 */
public class OptionalFlatMap {
    static String[] elements = {"12", "", "23", "45"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    /**
     * flatMap不会把结果包装在Optional中，因为映射函数已经被包装过了
     *
     * @param descr
     * @param func
     */
    static void test(String descr, Function<String, Optional<String>> func) {
        System.out.println(" ---(" + descr + ")--- ");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(
                    testStream()
                            .skip(i)
                            .findFirst()
                            .flatMap(func)
            );
        }
    }

    public static void main(String[] args) {
        test("Add brackets", s -> Optional.of("[" + s + "]"));
        test("increment", s -> {
            try {
                return Optional.of(Integer.parseInt(s) + 1 + "");
            } catch (NumberFormatException e) {
                return Optional.of(s);
            }
        });
        test("Replace", s -> Optional.of(s.replace("2", "9")));
        test("Take last digit", s -> Optional.of(s.length() > 0 ? s.charAt(s.length() - 1) + "" : s));
    }
}
