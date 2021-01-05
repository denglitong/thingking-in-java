package hiding;

/**
 * @autor denglitong
 * @date 2019/7/24
 */
public class Lauch {

    void testPrivate() {
        // has private access, can not access it
        // Soup1 soup1 = new Soup1();
    }

    void testStatic() {
        Soup1 soup1 = Soup1.makeSoup();
    }

    void testSingleton() {
        Soup2.access().f();
    }

}
