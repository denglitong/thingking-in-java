package typeinfo.toys;

/**
 * @author denglitong
 * @date 2021/1/17
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        // Class<Toy> up2 = ftClass.getSuperclass(); // won't compile
        // Toy toy = up.newInstance(); won't compile
        Object obj = up.newInstance();
    }
}
