package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/29
 */
public interface AnInterface {

    void firstMethod();

    void secondMethod();

    /**
     * 默认方法也被称为守卫方法或虚拟扩展方法
     */
    default void newMethod() {
        System.out.println("newMethod");
    }
}
