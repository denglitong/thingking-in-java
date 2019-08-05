package com.denglitong.innerclasses;

/**
 * 匿名内部类成员字段初始化的示例
 *
 * @autor denglitong
 * @date 2019/8/4
 */
public class Parcel9 {
    // 这里参数最好加上final表明初始化后参数引用不会改变
    // 即使不加final，Java8的编译器也会为我们自动加上final以保证数据的一致性
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
        System.out.println(d.readLabel());
    }
}
