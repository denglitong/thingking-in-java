import java.util.function.Supplier;

/**
 * 抽象工厂：不止拥有一个工厂方法而是几个工厂方法，每个工厂方法负责创建不同种类的对象
 *
 * @author litong.deng@foxmail.com
 * @date 2021/5/7
 */
interface Obstacle {
    void action();
}

interface Player {
    void interactWith(Obstacle o);
}

class Kitty implements Player {
    @Override
    public void interactWith(Obstacle o) {
        System.out.print("Kitty has encountered a ");
        o.action();
    }
}

class KungFuGuy implements Player {
    @Override
    public void interactWith(Obstacle o) {
        System.out.print("KungFuGuy now battles a ");
        o.action();
    }
}

class Puzzle implements Obstacle {
    @Override
    public void action() {
        System.out.println("Puzzle");
    }
}

class NastyWeapon implements Obstacle {
    @Override
    public void action() {
        System.out.println("NastyWeapon");
    }
}

// 抽象工厂类
abstract class GameElementFactory {
    Supplier<Player> player;
    Supplier<Obstacle> obstacle;
}

class KittiesAndPuzzles extends GameElementFactory {
    public KittiesAndPuzzles() {
        player = Kitty::new;
        obstacle = Puzzle::new;
    }
}

class KillAndDismember extends GameElementFactory {
    public KillAndDismember() {
        player = KungFuGuy::new;
        obstacle = NastyWeapon::new;
    }
}

public class GameEnvironment {
    private Player p;
    private Obstacle ob;

    public GameEnvironment(GameElementFactory factory) {
        p = factory.player.get();
        ob = factory.obstacle.get();
    }

    public void play() {
        p.interactWith(ob);
    }

    public static void main(String[] args) {
        GameElementFactory kp = new KittiesAndPuzzles();
        GameElementFactory kd = new KillAndDismember();
        GameEnvironment g1 = new GameEnvironment(kp);
        GameEnvironment g2 = new GameEnvironment(kd);
        g1.play();
        g2.play();
    }
}
