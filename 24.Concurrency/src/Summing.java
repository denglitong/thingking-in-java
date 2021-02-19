import com.dlt.Timer;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/14
 */
public class Summing {
	static void timeTest(String id, long checkValue, LongSupplier operation) {
		System.out.print(id + ": ");
		Timer timer = new Timer();
		long result = operation.getAsLong();
		if (result == checkValue) {
			System.out.println(timer.duration() + "ms");
		} else {
			System.out.format("result: %d%ncheckValue: %d%n", result, checkValue);
		}
	}

	public static final int SZ = 100000000;
	public static final long CHECK = (long) SZ * (SZ + 1) / 2;

	public static void main(String[] args) {
		System.out.println(CHECK);
		timeTest("Sum Stream", CHECK, () ->
				LongStream.rangeClosed(1, SZ).sum());
		// faster
		timeTest("Sum Stream Parallel", CHECK, () ->
				LongStream.rangeClosed(1, SZ).parallel().sum());
		// slower
		timeTest("Sum Iterated", CHECK, () ->
				LongStream.iterate(1, i -> i + 1).limit(SZ).sum());
		// much slower and may consume out of memory
		// timeTest("Sum Iterated Parallel", CHECK, () ->
		// 		LongStream.iterate(1, i -> i + 1).limit(SZ).parallel().sum());
	}
}
