/**
 * @autor denglitong
 * @date 2019/8/24
 */
// 如果有2个函数及以上，那么interface就是is not a functional interface
interface Strategy {
    String approach(String msg);
    // void unrelated();
}

class Soft implements Strategy {
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}

public class Strategize {
    Strategy strategy;
    String msg;

    Strategize(String msg) {
        strategy = new Soft(); // 1
        this.msg = msg;
    }

    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
                new Strategy() { // 2
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";
                    }
                },
                // Java8的Lambda表达式，由 -> 分开参数和函数体
                // 这实现了与定义类、匿名内部类相同的效果，但代码少得多
                msg1 -> msg1.substring(0, 5), // 3
                // Java8的方法应用，由 :: 区分，左边是类或对象的名称，右边是方法名称
                // 但没有参数列表
                Unrelated::twice
        };

        Strategize s = new Strategize("Hello there");
        s.communicate();
        // 此时传递的是行为，而不是数据
        for (Strategy strategy : strategies) {
            s.changeStrategy(strategy);
            s.communicate();
        }
    }
}
