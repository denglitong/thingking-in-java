package com.denglitong.validating;

/**
 * @autor denglitong
 * @date 2019/9/15
 */
public class LoaderAssertions {

    // 在系统的主类中用 static 快来判断是否开启断言
    static {
        boolean assertionsEnabled = false;
        // Note intentional side effect of assignment
        assert assertionsEnabled = true;
        if (!assertionsEnabled) {
            throw new RuntimeException("Assertions disabled");
        }
    }

    public static void main(String[] args) {
        ClassLoader.getSystemClassLoader()
                .setDefaultAssertionStatus(true);
        new Loaded().go();
    }
}

class Loaded {
    public void go() {
        assert false: "Loaded.go()";
    }
}