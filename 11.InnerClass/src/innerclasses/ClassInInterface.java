package innerclasses;

/**
 * 嵌套类可以作为接口的一部分，放到接口中的任何类都自动是public, static的
 * 你甚至可以在内部类中实现其外围接口
 * <p>
 * 如果你想要创建某些公共代码，使得它们可以被某个接口的所有不同实现所共用，
 * 那么使用接口内部的嵌套类会显得很方便
 *
 * @autor denglitong
 * @date 2019/8/4
 */
public interface ClassInInterface {
    void howdy();

    class Test implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
