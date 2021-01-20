import java.util.*;

/**
 * Class.getTypeParameters() 返回泛型生命中的类型参数，你只能看到占位符的标识，而不是具体类型信息
 * <p>
 * 在泛型代码内部，无法获取任何有关泛型参数类型的信息
 * Java 泛型是使用擦除实现的，这意味着当你在使用泛型时，任何具体的类型信息都被擦除了
 *
 * @author denglitong
 * @date 2021/1/18
 */
class Frob {}
class Fnorkle {}
class Quark<Q> {}
class Particle<POSITION, MOMENTUM> {}

public class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<>();
        // [E]
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));

        Map<Frob, Fnorkle> map = new HashMap<>();
        // [K, V]
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));

        Quark<Fnorkle> quark = new Quark<>();
        // [Q]
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));

        Particle<Long, Double> p = new Particle<>();
        // [POSITION, MOMENTUM]
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
    }
}
