/**
 * @author denglitong
 * @date 2021/1/14
 */
public class WhitherStringBuilder {
    public String implicit(String[] fields) {
        String result = "";
        for (String field : fields) {
            // 编译器自动引入的 StringBuilder 会在每次循环里创建一次
            result += field;
        }
        return result;
    }

    public String explicit(String[] fields) {
        StringBuilder result = new StringBuilder();
        for (String field : fields) {
            result.append(field);
        }
        return result.toString();
    }
}
