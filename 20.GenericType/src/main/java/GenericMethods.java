/**
 * 类本身可能是泛型的，也可能不是，不过这与它的方法是否是泛型的并没有什么关系
 * 泛型方法独立于类而改变方法
 * <p>
 * 普通的 static 方法无法访问该类的泛型类型参数，泛型的 static 方法可以访问类的泛型参数
 *
 * @author denglitong
 * @date 2021/1/18
 */
public class GenericMethods {
    // 函数的泛型参数由返回类型之前的 <T> 参数列表指示
    // 参数类型推断
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
    }
}
