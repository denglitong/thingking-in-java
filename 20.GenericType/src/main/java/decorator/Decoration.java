package decorator;

import java.util.Date;

/**
 * @author denglitong
 * @date 2021/1/20
 */
class Basic {
    private String value;
    public String get() {
        return value;
    }
    public void set(String value) {
        this.value = value;
    }
}

class Decorator extends Basic {
    protected Basic basic;
    Decorator(Basic basic) {
        this.basic = basic;
    }
    @Override
    public String get() {
        return basic.get();
    }
    @Override
    public void set(String value) {
        basic.set(value);
    }
}

class TimeStamped extends Decorator {
    private final long timestamp;
    TimeStamped(Basic basic) {
        super(basic);
        timestamp = new Date().getTime();
    }
    public long getStamp() { return timestamp; }
}

class SerialNumbered extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;
    SerialNumbered(Basic basic) {
        super(basic);
    }
    public long getSerialNumber() { return serialNumber; }
}

public class Decoration {
    public static void main(String[] args) {
        TimeStamped t1 = new TimeStamped(new Basic());
        // 装饰器所产生的对象类型是最后被修饰的类型
        // 尽管可以添加多个层，但是最后一层才是实际的类型，因此只有最后一层的方法是可视的
        // 其明显的缺陷是它只能有效地工作与装饰中的一层（最后一层）
        TimeStamped t2 = new TimeStamped(new SerialNumbered(new Basic()));
        // 不可用，因为只持有 Decorator 的引用，而不是 SerialNumbered 的引用
        // t2.getSerialNumber();
        SerialNumbered s1 = new SerialNumbered(new Basic());
        SerialNumbered s2 = new SerialNumbered(new TimeStamped(new Basic()));
        // 不可用，同上
        // s2.getStamp();

        System.out.println(t1.get() + " " + t1.getStamp());
        System.out.println(t2.get() + " " + t2.getStamp());
        System.out.println(s1.get() + " " + s1.getSerialNumber());
        System.out.println(s2.get() + " " + s2.getSerialNumber());
    }
}
