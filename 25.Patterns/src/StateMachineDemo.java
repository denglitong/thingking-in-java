/**
 * 状态机模式：桥接模式允许程序员更改实现，状态机利用一个结构来自动地讲实现更改到下一个
 *
 * @author litong.deng@foxmail.com
 * @date 2021/5/6
 */
interface IState {
    void run();
}

abstract class StateMachine {
    protected IState currentState;

    protected abstract boolean changeState();

    // template method
    protected final void runAll() {
        // 在这里控制状态的类负责决定下一个状态
        // 然而状态对象本身也可以决定下一步移动到什么状态，通常基于系统的输入会是更灵活的解决方案
        while (changeState()) {
            currentState.run();
        }
    }
}

class Wash implements IState {
    @Override
    public void run() {
        System.out.println("Washing");
        new Nap(0.5);
    }
}

class Spin implements IState {
    @Override
    public void run() {
        System.out.println("Spinning");
        new Nap(0.5);
    }
}

class Rinse implements IState {
    @Override
    public void run() {
        System.out.println("Rinsing");
        new Nap(0.5);
    }
}

class Washer extends StateMachine {
    private int i = 0;

    private IState[] states = {
            new Wash(), new Spin(),
            new Rinse(), new Spin(),
    };

    public Washer() {
        runAll();
    }

    @Override
    protected boolean changeState() {
        if (i < states.length) {
            // change the state by setting the surrogate reference to a new object:
            currentState = states[i++];
            return true;
        } else {
            return false;
        }
    }
}

public class StateMachineDemo {
    public static void main(String[] args) {
        new Washer();
    }
}
