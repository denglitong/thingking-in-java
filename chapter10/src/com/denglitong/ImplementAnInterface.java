package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/29
 */
interface Concept {
    void idea1();
    void idea2();
}

public class ImplementAnInterface implements Concept {
    @Override
    public void idea1() {
        System.out.println("idea1");
    }

    @Override
    public void idea2() {
        System.out.println("idea2");
    }
}
