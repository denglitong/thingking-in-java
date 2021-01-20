/**
 * @author denglitong
 * @date 2021/1/18
 */
public class Manipulator3 {
    /**
     * 泛型参数只有在比某个具体类型更加"泛化"的时候才能发挥应用的作用
     * 泛化：跨多个类
     */
    private HasF obj;

    public Manipulator3(HasF obj) {
        this.obj = obj;
    }

    public void manipulate() {
        obj.f();
    }
}
