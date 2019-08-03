package com.denglitong.interfaces;

/**
 * @autor denglitong
 * @date 2019/8/1
 */
interface CanFight {

    void fight();

}

interface CanSwim {

    void swim();

}

interface CanFly {

    void fly();

}

class ActionCharacter {

    public void fight() {
    }

}

/**
 * ActionCharacter没有显示定义CanFly中定义的fight()方法，但因为ActionCharacter中已经定义了所以没有报错
 * 记住一个原则：当想创建一个对象时，所以的定义必须首先都存在
 */
class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {

    @Override
    public void swim() {

    }

    @Override
    public void fly() {

    }

}

public class Adventure {

    /**
     * 使用接口的核心原因之一：为了能够向上转型为多个基类型（以及由此带来的灵活性）
     *
     * @param x
     */
    public static void t(CanFight x) {
        x.fight();
    }

    public static void u(CanSwim x) {
        x.swim();
    }

    public static void v(CanFly x) {
        x.fly();
    }

    public static void w(ActionCharacter x) {
        x.fight();
    }

    public static void main(String[] args) {
        Hero h = new Hero();
        t(h);
        u(h);
        v(h);
        w(h);
    }

}
