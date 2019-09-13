package com.denglitong.exceptions;

/**
 * @autor denglitong
 * @date 2019/9/8
 */
class EBase1 extends Exception {}
class Excep1 extends EBase1 {}
class EBase2 extends Exception {}
class Excep2 extends EBase2 {}
class EBase3 extends Exception {}
class Excep3 extends EBase3 {}
class EBase4 extends Exception {}
class Excep4 extends EBase4 {}

public class SameHandler {
    void x() throws Excep1, Excep2, Excep3, Excep4 {}
    void process() {}

    // 在 Java7 之前，你必须为每一个类型编写一个 catch:
    void f() {
        try {
            x();
        } catch (Excep1 e) {
            process();
        } catch (Excep2 e) {
            process();
        } catch (Excep3 e) {
            process();
        } catch (Excep4 e) {
            process();
        }
    }

    // 在 Java7 之后，你可以使用多重捕获机制，将不同类型的异常使用"或"将它们组合起来
    // 这对书写更整洁的代码很有帮助
    void g() {
        try {
            x();
        } catch (Excep1 | Excep2 | Excep3 | Excep4 e) {
            process();
        }
    }
}
