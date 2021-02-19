import java.util.Arrays;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/14
 */
public class Summing2 {
	static long basicSum(long[] ia) {
		long sum = 0;
		for (long l : ia) {
			sum += l;
		}
		return sum;
	}

	public static final int SZ = 20000000;
	public static final long CHECK = (long) SZ * (SZ + 1) / 2;

	public static void main(String[] args) {
		System.out.println(CHECK);
		long[] la = new long[SZ + 1];
		Arrays.parallelSetAll(la, i -> i);
		Summing.timeTest("Array Stream Sum", CHECK, () ->
				Arrays.stream(la).sum());
		Summing.timeTest("Parallel", CHECK, () ->
				Arrays.stream(la).parallel().sum());
		Summing.timeTest("Basic Sum", CHECK, () ->
				basicSum(la));
		Summing.timeTest("parallelPrefix", CHECK, () -> {
			Arrays.parallelPrefix(la, Long::sum);
			return la[la.length - 1];
		});
	}
}
