package innerclasses;

/**
 * @autor denglitong
 * @date 2019/8/4
 */
public class TestBed {
    public void f() {
        System.out.println("f()");
    }

    /**
     * 可以使用内部嵌套类来放置测试代码，这会被编译成一个独立的类并可以在发布的产品中删除它
     * 这相对于你直接在外部类中放置一个main()方法，可以减少这部分的额外代码的开销
     */
    public static class Tester {
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }
}
