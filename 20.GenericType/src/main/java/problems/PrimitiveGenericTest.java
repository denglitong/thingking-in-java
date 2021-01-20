package problems;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

/**
 * @author denglitong
 * @date 2021/1/20
 */
interface FillArray {
    static <T> T[] fill(T[] a, Supplier<T> gen) {
        Arrays.setAll(a, n -> gen.get());
        return a;
    }

    static int[] fill(int[] a, IntSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsInt());
        return a;
    }

    static long[] fill(long[] a, LongSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsLong());
        return a;
    }

    static double[] fill(double[] a, DoubleSupplier gen) {
        Arrays.setAll(a, n -> gen.getAsDouble());
        return a;
    }
}

class StringSupplier implements Supplier<String> {
    private int length;

    public StringSupplier(int count) {
        this.length = count;
    }

    @Override
    public String get() {
        return RandomStringUtils.randomAlphabetic(length);
    }
}

class IntegerSupplier implements IntSupplier {
    @Override
    public int getAsInt() {
        return new Random().nextInt();
    }
}

public class PrimitiveGenericTest {
    public static void main(String[] args) {
        String[] strings = FillArray.fill(new String[5], new StringSupplier(9));
        System.out.println(Arrays.toString(strings));

        int[] ints = FillArray.fill(new int[9], new IntegerSupplier());
        System.out.println(Arrays.toString(ints));
    }
}
