package com.denglitong.nesting;

/**
 * 一旦你了解了某种特性，就总能找到其用武之地
 *
 * @autor denglitong
 * @date 2019/8/3
 */
class A {
    interface B {
        void f();
    }

    public class BImpl implements B {
        @Override
        public void f() {}
    }

    public class BImpl2 implements B {
        @Override
        public void f() {}
    }

    public interface C {
        void f();
    }

    class CImpl implements C {
        @Override
        public void f() {}
    }

    public class CImpl2 implements C {
        @Override
        public void f() {}
    }

    private interface D {
        void f();
    }

    private class DImpl implements D {
        @Override
        public void f() {}
    }

    /**
     * 实现private interface的用途：
     * 一种强制该接口中的方法不会添加任何类型信息（即不可以向上转型）的方式
     */
    public class DImpl2 implements D {
        @Override
        public void f() {}
    }

    public D getD() {
        return new DImpl2();
    }

    private D dRef;

    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }
}

interface E {
    interface G {
        void f();
    }

    // Redundant "public"
    public interface H {
        void f();
    }

    void g();

    // cannot be private within an interface
    // private interface I {}
}

public class NestingInterfaces {
    public class BImpl implements A.B {
        @Override
        public void f() {}
    }

    class CImpl implements A.C {
        @Override
        public void f() {}
    }

    // cannot implements a private interface except
    // within that interface's defining class:
    // class DImpl implements A.D {
    //
    // }

    class EGImpl implements E.G {
        @Override
        public void f() {}
    }

    /**
     * 实现一个接口时并不需要实现其内部接口
     */
    class EImpl2 implements E {
        @Override
        public void g() {}

        class EG implements E.G {
            @Override
            public void f() {}
        }
    }

    public static void main(String[] args) {
        A a = new A();
        // can't access to A.D
        // A.D ad = a.getD();
        // A.DImpl2 dImpl2 = a.getD();
        // can't access a member of the interface:
        // a.getD().f();
        A a2 = new A();
        a2.receiveD(a.getD());
    }
}
