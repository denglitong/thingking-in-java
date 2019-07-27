package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/26
 */

class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        //  对于没有默认午餐的基类必须调用super()来显式初始化
        super(i);
        System.out.println("Board constructor");
    }
}

public class Chess extends BoardGame{

    public Chess() {
        super(11);
        System.out.println("Ches constructor");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }

}
