/**
 * @author litong.deng@foxmail.com
 * @date 2021/5/7
 */
public class Shape {
    private static int counter = 0;
    private int id = counter++;

    @Override
    public String toString() {
        // getClass() 将使用运行期信息来获取特定的子类类型
        return getClass().getSimpleName() + "[" + id + "]";
    }

    public void draw() {
        System.out.println(this + " draw");
    }

    public void erase() {
        System.out.println(this + " erase");
    }
}
