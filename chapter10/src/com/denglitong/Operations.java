package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/29
 */
public interface Operations {

    void execute();

    /**
     * 这是模板方法设计的一个版本, runOps是一个模板方法
     *
     * @param ops
     */
    static void runOps(Operations... ops) {
        for (Operations op : ops) {
            op.execute();
        }
    }

    static void show(String msg) {
        System.out.println(msg);
    }

}
