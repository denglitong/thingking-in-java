package com.denglitong;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @autor denglitong
 * @date 2019/7/17 10:16
 */
public enum OptType {
    // 枚举值就是枚举类型的一个类对象，后面可跟初始化参数
    init(1, "hello, world");

    private int number;
    private String name;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    OptType(int number, String name) {
        this.number = number;
        this.name = name;
    }
}
