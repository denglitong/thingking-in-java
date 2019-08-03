package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/28
 */
abstract class AbstractAccess {
    private void m1() {}

    // illegal, 因为不能在子类中定义它
    // private abstract void m1a();

    protected void m2() {}

    void m3() {}

    abstract void m3a();

    public void m4() {}

    public abstract void m4a();
}
