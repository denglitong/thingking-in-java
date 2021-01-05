/**
 * @autor denglitong
 * @date 2019/7/28
 */

class Actor {
    public void act() {}
}

class HappyActor extends Actor {
    @Override
    public void act() {
        System.out.println("HappyActor");
    }
}

class SadActor extends Actor {
    @Override
    public void act() {
        System.out.println("SadActor");
    }
}

class Stage {
    private Actor actor = new HappyActor();

    /**
     * 引用可以在运行时与不同对象绑定，表现的行为随之改变
     * 这样你就获得了运行时的动态灵活性（这杯称为状态模式）
     * 一条通用准则：使用继承表达行为的差异，使用属性表达状态的变化
     */
    public void change() {
        actor = new SadActor();
    }

    public void performPlay() {
        actor.act();
    }
}

public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}
