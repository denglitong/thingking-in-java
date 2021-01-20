package problems;

/**
 * 编译不了
 * extends ComparablePet 指定的 implements Comparable<ComparablePet>
 * 在子类不能实现其他类型的 Comparable
 *
 * @author denglitong
 * @date 2021/1/20
 */
// class Cat extends ComparablePet implements Comparable<Cat> {
//     @Override
//     public int compareTo(Cat o) {
//         return 0;
//     }
// }
class Hamster extends ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}

// 下面的写法和上面是等效的，相当于覆盖写基类的方法完全相同
class Gecko extends ComparablePet {
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}

public class HijackedInterface {
}
