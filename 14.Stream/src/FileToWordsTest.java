/**
 * 真正的流不依赖代码中的集合存储，每次使用都从头创建，因为流并不能被复用
 *
 * @autor denglitong
 * @date 2019/9/1
 */
public class FileToWordsTest {
    public static void main(String[] args) throws Exception {
        String filePath = "/Users/leon/javaspace/thingking-in-java/chapter14/src/Cheese.dat";
        FileToWords.stream(filePath)
                .limit(7)
                .forEach(s -> System.out.format("%s ", s));
        System.out.println();

        FileToWords.stream(filePath)
                .skip(7)
                .limit(2)
                .forEach(s -> System.out.format("%s ", s));
    }
}
