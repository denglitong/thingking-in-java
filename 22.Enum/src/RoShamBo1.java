import java.util.Random;

/**
 * 多路分发
 *
 * @author denglitong
 * @date 2021/1/24
 */
interface Item {
    // 多路分发，根据 Item 的类型分发到具体子类型的 compete 实现
    Outcome compete(Item it);
    Outcome eval(Paper p);
    Outcome eval(Scissors s);
    Outcome eval(Rock s);
}

// 布
class Paper implements Item {
    @Override
    public Outcome compete(Item it) {
        // 二次分发，将调用具体子类型的 eval 实现
        return it.eval(this);
    }
    @Override
    public Outcome eval(Paper p) {
        return Outcome.DRAW;
    }
    @Override
    public Outcome eval(Scissors s) {
        return Outcome.WIN;
    }
    @Override
    public Outcome eval(Rock s) {
        return Outcome.LOSE;
    }
    @Override
    public String toString() {
        return "Paper";
    }
}

// 剪刀
class Scissors implements Item {
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }
    @Override
    public Outcome eval(Paper p) {
        return Outcome.WIN;
    }
    @Override
    public Outcome eval(Scissors s) {
        return Outcome.DRAW;
    }
    @Override
    public Outcome eval(Rock s) {
        return Outcome.LOSE;
    }
    @Override
    public String toString() {
        return "Scissors";
    }
}

// 石头
class Rock implements Item {
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }
    @Override
    public Outcome eval(Paper p) {
        return Outcome.LOSE;
    }
    @Override
    public Outcome eval(Scissors s) {
        return Outcome.WIN;
    }
    @Override
    public Outcome eval(Rock s) {
        return Outcome.DRAW;
    }
    @Override
    public String toString() {
        return "Rock";
    }
}

public class RoShamBo1 {
    static final int SIZE = 20;
    private static Random rand = new Random(47);

    public static Item newItem() {
        switch (rand.nextInt(3)) {
            // default 如果放在最后则需提供 return 语句
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }

    public static void match(Item a, Item b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }
}
