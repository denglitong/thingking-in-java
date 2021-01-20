package problems;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author denglitong
 * @date 2021/1/20
 */
public class ListOfInt {
    public static void main(String[] args) {
        List<Integer> li = IntStream.range(38, 48) // [)
                .boxed() // 基本类型封箱为封装类型 int -> Integer
                .collect(Collectors.toList());
        System.out.println(li);
    }
}
