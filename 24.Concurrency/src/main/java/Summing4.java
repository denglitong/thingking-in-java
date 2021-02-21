import java.util.Arrays;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/14
 */
public class Summing4 {
	public static void main(String[] args) {
		System.out.println(Summing.CHECK);
		Long[] aL = new Long[Summing.SZ + 1];
		Arrays.parallelSetAll(aL, i -> (long) i);
		Summing.timeTest("Long Parallel", Summing.CHECK, () ->
				Arrays.stream(aL)
						.parallel()
						.reduce(0L, Long::sum));
	}
}
