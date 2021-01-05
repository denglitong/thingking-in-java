/**
 * @autor denglitong
 * @date 2019/7/27
 */

class SmallBrain {}

// final类由于禁止继承，类中所以的方法都隐式地隐式的指定为final
final class Dinosaur {
    int i = 7;
    int j = 1;
    SmallBrain x = new SmallBrain();

    void f() {}
}

// can not inherit final class
// public class Jurassic extends Dinosaur {
public class Jurassic {
    public static void main(String[] args) {
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
    }
}
