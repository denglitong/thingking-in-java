package typeinfo.interfacea;

import java.lang.reflect.Method;

/**
 * @author denglitong
 * @date 2021/1/17
 */
public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());

        // Ooops! Reflection still allow us to call g():
        // 通过使用反射机制，仍然可以调用所有方法，甚至是 private 方法！
        callHiddenMethod(a, "g");
        // And even less accessible methods!
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(Object a, String methodName) throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
