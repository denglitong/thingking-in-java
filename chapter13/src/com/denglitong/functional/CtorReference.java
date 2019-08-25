package com.denglitong.functional;

/**
 * @autor denglitong
 * @date 2019/8/24
 */
class Dog {
    String name;
    int age = -1;
    public Dog() { name = "stray"; }
    public Dog(String name) {
        this.name = name;
    }
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Arg {
    Dog make(String name);
}

interface Make2Args {
    Dog make(String name, int age);
}

public class CtorReference {
    public static void main(String[] args) {
        // 编译器可以检测并知道从哪个构造含义引用
        MakeNoArgs makeNoArgs = Dog::new;
        Make1Arg make1Arg = Dog::new;
        Make2Args make2Args = Dog::new;

        // 编译器能识别并调用对应的构造函数
        Dog dn = makeNoArgs.make();
        Dog d1 = make1Arg.make("Comet");
        Dog d2 = make2Args.make("Ralph", 4);
    }
}
