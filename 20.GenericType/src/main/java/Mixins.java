import java.util.Date;

/**
 * @author denglitong
 * @date 2021/1/20
 */
interface TimeStamped {
    long getStamp();
}

class TimeStampedImp implements TimeStamped {
    private final long timestamp;
    TimeStampedImp() {
        timestamp = new Date().getTime();
    }
    @Override
    public long getStamp() {
        return timestamp;
    }
}

interface SerialNumbered {
    long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;
    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Basic {
    void set(String val);
    String get();
}

class BasicImp implements Basic {
    private String value;
    @Override
    public void set(String val) {
        value = val;
    }
    @Override
    public String get() {
        return value;
    }
}

/**
 * 委托模式
 * <p>
 * 委托模式下每个混入类型都要求在 Mixin 中有一个相应的域，当混型变复杂时代码数量会急速增加
 * 混型是基于继承的
 */
class Mixin extends BasicImp implements TimeStamped, SerialNumbered {
    private TimeStamped timeStamped = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();

    @Override
    public long getStamp() {
        return timeStamped.getStamp();
    }
    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }

    @Override
    public String toString() {
        return get() + " " + getStamp() + " " + getSerialNumber();
    }
}

public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin();
        Mixin mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1);
        System.out.println(mixin2);
    }
}