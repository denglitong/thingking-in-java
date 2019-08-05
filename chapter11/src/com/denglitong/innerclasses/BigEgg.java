package com.denglitong.innerclasses;

/**
 * @autor denglitong
 * @date 2019/8/5
 */
class Egg {
    private Yolk y;

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    public Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }
}

public class BigEgg extends Egg {
    /**
     * 当继承某个外围类的时候，内部类就没有发生什么神奇的变化
     * 这两个内部类是完全独立的两个实体，各自在自己的命名空间内
     * 要想覆盖外围类的内部类，需要你显式的指定要继承的外围内部类
     */
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
        // output:
        // New EGG()
        // Egg.Yolk()
    }
}
