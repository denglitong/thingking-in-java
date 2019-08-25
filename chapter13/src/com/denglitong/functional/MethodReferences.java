package com.denglitong.functional;

/**
 * @autor denglitong
 * @date 2019/8/24
 */
interface Callable {
    void call(String s);
}

class Describe {
    void show(String msg) {
        System.out.println(msg);
    }
}

public class MethodReferences {
    static void hello(String name) {
        System.out.println("Hello, " + name);
    }

    static class Description {
        String about;
        public Description(String about) {
            this.about = about;
        }
        void help(String msg) {
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static void assist(String msg) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        // interface不能通过new InterfaceClass()来实例化
        // 可以理解为它是一种特殊的指针，指向具体实现，调用的时候再延迟绑定
        // 函数签名需要一致
        Callable c = d::show;
        c.call("call()");

        c = MethodReferences::hello;
        c.call("Bob");

        c = new Description("variable")::help;
        c.call("information");

        c = Helper::assist;
        c.call("Help!");
    }

}
