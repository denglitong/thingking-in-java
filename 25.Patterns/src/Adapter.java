/**
 * 有时候我们需要解决的问题很简单：仅仅是"我没有需要的接口而已"
 * 适配器模式：接受一种类型并提供一个对其他类型的接口；
 * 外观模式：为一组类创建一个接口，提供一种更方便的方法来处理库或资源
 * <p>
 * 代理适配器：proxy adapter
 *
 * @author litong.deng@foxmail.com
 * @date 2021/5/10
 */
class WhatIHave {
    public void g() {
        System.out.println("g()");
    }

    public void h() {
        System.out.println("h()");
    }
}

interface WhatIWant {
    void f();
}

class ProxyAdapter implements WhatIWant {
    WhatIHave whatIHave;

    public ProxyAdapter(WhatIHave whatIHave) {
        this.whatIHave = whatIHave;
    }

    @Override
    public void f() {
        // implement behavior using methods in WhatIHave:
        whatIHave.g();
        whatIHave.h();
    }
}

class WhatIUse {
    public void op(WhatIWant want) {
        want.f();
    }
}

// approach 2: build adapter use into op():
class WhatIUse2 extends WhatIUse {
    public void op(WhatIHave have) {
        new ProxyAdapter(have).f();
    }
}

// approach 3: build adapter into WhatIHave:
class WhatIHave2 extends WhatIHave implements WhatIWant {
    @Override
    public void f() {
        g();
        h();
    }
}

// approach 4: use an inner class:
class WhatIHave3 extends WhatIHave {
    private class InnerAdapter implements WhatIWant {
        @Override
        public void f() {
            g();
            h();
        }
    }

    public WhatIWant whatIWant() {
        return new InnerAdapter();
    }
}

public class Adapter {
    public static void main(String[] args) {
        WhatIUse whatIUse = new WhatIUse();
        WhatIHave whatIHave = new WhatIHave();
        WhatIWant adapt = new ProxyAdapter(whatIHave);
        whatIUse.op(adapt);
        // approach 2:
        WhatIUse2 whatIUse2 = new WhatIUse2();
        whatIUse2.op(whatIHave);
        // approach 3:
        WhatIHave2 whatIHave2 = new WhatIHave2();
        whatIUse.op(whatIHave2);
        // approach 4:
        WhatIHave3 whatIHave3 = new WhatIHave3();
        whatIUse.op(whatIHave3.whatIWant());
    }
}
