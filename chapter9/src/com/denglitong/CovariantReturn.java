package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/28
 */

class Grain {
    @Override
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {
    @Override
    public String toString() {
        return "Wheat";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {
    @Override
    // 在 Java5 的时候复写的方法要求返回的类型必须是 Grain
    // 但 Wheat 是一种更具体的 Grain 类型，因而在 Java8 中允许返回 Wheat 类型
    Wheat process() {
        return new Wheat();
    }
}

public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);
        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
}
