package covriant;

/**
 * @author denglitong
 * @date 2021/1/20
 */
public class CaptureConversion {
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    /**
     * 捕获转换：未指定的通配符类型被捕获，并被转换为具体类型
     * 捕获只有在方法内部需要使用切确的类型的时候才可以工作
     * <p>
     * 注意这里不能从 f2 返回 T，因为 T 对于 f2 来说是未知的
     *
     * @param holder
     */
    static void f2(Holder<?> holder) {
        f1(holder);
    }

    public static void main(String[] args) {
        Holder raw = new Holder(1); // warning
        f1(raw); // warning

        f2(raw); // no warning

        Holder rawBasic = new Holder();
        rawBasic.set(new Object()); // warning

        f2(rawBasic); // nowarning

        Holder<?> wildcarded = new Holder<>(1.0);
        f2(wildcarded);
    }
}
