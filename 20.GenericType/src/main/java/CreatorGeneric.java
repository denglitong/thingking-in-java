/**
 * @author denglitong
 * @date 2021/1/19
 */
abstract class GenericWithCreate<T> {
    final T element;

    public GenericWithCreate() {
        element = create();
    }
    
    abstract T create();
}

class X {}

class XCreator extends GenericWithCreate<X> {
    @Override
    X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {
    public static void main(String[] args) {
        XCreator xc = new XCreator();
        // X
        xc.f();
    }
}
