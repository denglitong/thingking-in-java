import java.util.Optional;

/**
 * 生成Optional
 * empty() 产生一个空 Optional
 * of(value) 将一个非空值包装到 Optional 里
 * ofNullable(value) 针对一个可能为空的值，为空时自动生成 Optional.empty，
 * 否则将值包装在 Optional 中
 *
 * @autor denglitong
 * @date 2019/9/2
 */
public class CreatingOptionals {
    static void test(String testName, Optional<String> opt) {
        System.out.println(" === " + testName + " === ");
        System.out.println(opt.orElse("Null"));
    }

    public static void main(String[] args) {
        test("empty", Optional.empty());
        test("of", Optional.of("Howdy"));
        try {
            test("of", Optional.of(null));
        } catch (Exception e) {
            System.out.println(e); // NullPointerException
        }
        test("ofNullable", Optional.ofNullable("Hi"));
        test("ofNullable", Optional.ofNullable(null));
    }
}
