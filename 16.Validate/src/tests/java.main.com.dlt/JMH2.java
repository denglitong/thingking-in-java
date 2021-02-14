package test.java.com.dlt;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author denglitong
 * @date 2021/1/5
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(1)
public class JMH2 {
	private long[] la;

	@Param({
			"1",
			"10",
			"100",
			"1000",
			"10000",
			"100000",
			"1000000",
			"10000000",
			"100000000",
			"250000000",
	})
	int size;

	@Setup
	public void setUp() {
		la = new long[size];
	}

	@Benchmark
	public void setAll() {
		Arrays.setAll(la, n -> n);
	}

	@Benchmark
	public void parallelSetAll() {
		Arrays.parallelSetAll(la, n -> n);
	}

	@Test
	public void benchmark() throws Exception {
		String[] argv = {};
		org.openjdk.jmh.Main.main(argv);
	}
}
