package interfaces;

/**
 * @autor denglitong
 * @date 2019/8/1
 */
interface Monster {

    void menace();

}

interface DangeroursMonster extends Monster {

    void destroy();

}

interface Lethal {

    void kill();

}

class DragonZilla implements DangeroursMonster {

    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }

}

/**
 * extends只能用于单一类，但是在构建接口时可以引用多个基类接口
 */
interface Vampire extends DangeroursMonster, Lethal {

    void drinkBlood();

}

class VeryBadVampire implements Vampire {

    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void kill() {

    }

    @Override
    public void drinkBlood() {

    }

}

public class HorrorShow {

    static void u(Monster b) {
        b.menace();
    }

    static void v(DangeroursMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        DangeroursMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }

}
