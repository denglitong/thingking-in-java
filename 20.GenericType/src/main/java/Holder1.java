/**
 * @author denglitong
 * @date 2021/1/17
 */
class Automobile {}

public class Holder1 {
    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    public Automobile get() {
        return a;
    }
}
