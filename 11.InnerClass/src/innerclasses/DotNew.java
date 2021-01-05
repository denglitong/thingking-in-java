package innerclasses;

/**
 * 要想直接创建内部类的对象，不能直接去引用外部类的名字.内部类，而是必须使用外部类的对象来创建
 * 外部类对象 .new 内部类
 * @autor denglitong
 * @date 2019/8/4
 */
public class DotNew {
    public class Inner {}

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        // 使用类对象的 .new 语法来告知其要创建内部类的对象
        DotNew.Inner dni = dn.new Inner();
        // can not reference in static context
        // DotNew.Inner dni2 = new DotNew.Inner();
    }
}
