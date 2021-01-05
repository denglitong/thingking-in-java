package innerclasses;

/**
 * @autor denglitong
 * @date 2019/8/4
 */
interface Incrementable {
    void increment();
}

class Callee1 implements Incrementable {
    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    public void increment() {
        System.out.println("Other operation");
    }
    static void f(MyIncrement mi) {
        mi.increment();
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;
    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    private class Closure implements Incrementable {
        @Override
        public void increment() {
            // specify outer-class method, otherwise you'll get an infinite recusion
            Callee2.this.increment();
        }
    }

    // 回调的价值在于它的灵活性-可以在运行时动态的决定需要调用什么方法
    // 例如在图形界面实现GUI功能的时候到处都用到回调
    Incrementable getCallbackReference() {
        return new Closure();
    }
}

class Caller {
    private Incrementable callbackReference;
    public Caller(Incrementable callbackReference) {
        this.callbackReference = callbackReference;
    }
    void go() {
        callbackReference.increment();
    }
}

public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
