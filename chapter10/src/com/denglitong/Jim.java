package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/29
 */
interface Jim1 {

    default void jim() {
        System.out.println("Jim1::jim");
    }

}

interface Jim2 {

    default void jim() {
        System.out.println("Jim2::jim");
    }

}

public class Jim implements Jim1, Jim2 {

    /**
     * 对接口有冲突的方法需要进行复写才能解决冲突
     */
    @Override
    public void jim() {
        Jim2.super.jim();
    }

    public static void main(String[] args) {
        new Jim().jim();
    }

}
