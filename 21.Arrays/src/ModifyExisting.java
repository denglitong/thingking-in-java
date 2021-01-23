import java.util.Arrays;

/**
 * @author denglitong
 * @date 2021/1/23
 */
public class ModifyExisting {
    public static void main(String[] args) {
        double[] da = new double[7];
        Arrays.setAll(da, new Rand.Double()::get);
        ArrayShow.show(da);

        Arrays.setAll(da, n -> da[n] / 100);
        ArrayShow.show(da);
    }
}
