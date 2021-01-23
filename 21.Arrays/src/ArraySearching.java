import java.util.Arrays;

/**
 * @author denglitong
 * @date 2021/1/23
 */
public class ArraySearching {
    public static void main(String[] args) {
        int[] a = new Rand.Pint().array(25);
        Arrays.sort(a);
        ArrayShow.show("Sorted array", a);

        Rand.Pint rand = new Rand.Pint();
        while (true) {
            int r = rand.getAsInt();
            int location = Arrays.binarySearch(a, r);
            if (location >= 0) {
                System.out.println("Location of " + r + " is " + location + ", " +
                        "a[" + location + "] is " + a[location]);
                break;
            }
        }
    }
}
