import java.util.stream.Stream;

/**
 * @author denglitong
 * @date 2021/1/14
 */
public class InfiniteRecursion {
    @Override
    public String toString() {
        // 会产生递归调用, this -> this.toString()
        // return " InfiniteRecursion address: " + this + "\n";
        // super.String() 会返回对象的 String 表示，默认是对象的地址
        return " InfiniteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        Stream.generate(InfiniteRecursion::new)
                .limit(10)
                .forEach(System.out::println);
    }
}
