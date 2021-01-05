package innerclasses;

/**
 * @autor denglitong
 * @date 2019/8/4
 */
public class Parcel10 {
    public Destination destination(final String dest, final float price) {
        /**
         * 匿名内部类与正规的继承相比有些受限，匿名内部类既可以扩展类，也可以实现接口
         * 但是不能两者兼顾，而且如果实现接口也只能实现一个接口
         */
        return new Destination() {
            private int cost;
            // 对于匿名类而言，实例初始化的实际效果就是构造器
            // 当然它收到了限制-你不能重载实例初始化方法，所以你仅有一个这样的构造器
            // instance initialization for each object:
            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Over budget!");
                }
            }

            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination D = p.destination("Tasmania", 101.395F);
    }
}
