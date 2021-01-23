import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author denglitong
 * @date 2021/1/21
 */
class BerylliumSphere {
    private static long counter;
    private final long id = counter++;
    @Override
    public String toString() {
        return "Shpere " + id;
    }
}

public class CollectionComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++) {
            spheres[i] = new BerylliumSphere();
        }
        ArrayShow.show(spheres);
        System.out.println(spheres[4]);

        List<BerylliumSphere> sphereList = Suppliers.create(
                ArrayList::new, BerylliumSphere::new, 5);
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));

        // 对象数组中的数据集实际上都是对堆中真正对象的引用
        // 基元数组则直接存储基本数据类型的值
        // 数组唯一可用的方法是 length 成员
        int[] ints = {0, 1, 2, 3, 4, 5};
        ArrayShow.show(ints);

        List<Integer> integers = new ArrayList<>(
                Arrays.asList(0, 1, 2, 3, 4, 5));
        integers.add(97);
        System.out.println(integers);
        System.out.println(integers.get(4));

    }
}
