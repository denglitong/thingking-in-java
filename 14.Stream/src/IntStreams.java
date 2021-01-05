/**
 * @autor denglitong
 * @date 2019/8/29
 */
public class IntStreams {
    public static void main(String[] args) {
        // 传统方式
        int result = 0;
        for (int i = 10; i < 20; i++) {
            result += i;
        }
        System.out.println(result);

        // for-in循环
        result = 0;
        for (int i : java.util.stream.IntStream.range(10, 20).toArray()) {
            result += i;
        }
        System.out.println(result);

        // 使用流：
        System.out.println(java.util.stream.IntStream.range(10, 20).sum());
    }
}
