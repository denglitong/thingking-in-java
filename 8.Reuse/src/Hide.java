/**
 * 重载函数是不同的函数签名，子类和基类可以重载函数
 * 但是更常见的则是Override而不是重载因为这会让人困惑
 * @autor denglitong
 * @date 2019/7/27
 */

class Homer {
    char doh(char c) {
        System.out.println("doh(char)");
        return 'd';
    }
    float doh(float f) {
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class Milhouse {}

class Bart extends Homer {
    void doh(Milhouse m) {
        System.out.println("doh(Milhouse)");
    }
}

class Lisa extends Homer {
    /**
     * @Override 重写保证函数签名一致，防止你写错函数签名而变成重载
     * @param c
     * @return
     */
    @Override
    char doh(char c) {
        return super.doh(c);
    }
}

public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
}
