/**
 * @author denglitong
 * @date 2021/1/17
 */
class Building {}
class House extends Building {}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        // 强制类型转换
        House h = houseType.cast(b);
        h = (House)b;
        if (b instanceof House) {
            h = (House)b;
        }
    }
}
