import java.util.Arrays;

/**
 * @autor denglitong
 * @date 2019/7/30
 */
class Processor {

    public String name() {
        return getClass().getSimpleName();
    }

    public Object process(Object input) {
        return input;
    }

}

class Upcase extends Processor {

    // 返回协变类型
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }

}

class Downcase extends Processor {

    @Override
    public Object process(Object input) {
        return ((String) input).toLowerCase();
    }

}

class Splitter extends Processor {

    @Override
    public Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }

}

public class Applicator {

    /**
     * 创建一个能更具传入的参数类型从而具备不同行为的方法称之为 策略设计模式
     * 方法包含算法中不变的部分，策略包含变化的部分
     * 策略就是传入的对象，它包含要执行的代码
     *
     * @param p
     * @param s
     */
    public static void apply(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }

    public static void main(String[] args) {
        String s = "We are such stuff as dreams are made on";
        apply(new Upcase(), s);
        apply(new Downcase(), s);
        apply(new Splitter(), s);
    }

}
