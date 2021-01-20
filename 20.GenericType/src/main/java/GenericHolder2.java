/**
 * @author denglitong
 * @date 2021/1/19
 */
public class GenericHolder2<T> {
    private T obj;

    // 泛型的所有动作都发生的边界处--
    // 对入参的检查、对返回值的转型
    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        GenericHolder2<String> holder = new GenericHolder2<>();
        holder.setObj("Item");
        String s = holder.getObj();
    }
}
