package com.denglitong.interfaceprocessor;

/**
 * @autor denglitong
 * @date 2019/7/31
 */
public class Applicator {

    public static void apply(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }

}
