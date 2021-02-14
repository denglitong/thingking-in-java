package main.java.com.dlt;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @author denglitong
 * @date 2021/1/5
 */
public class Timer {
	private long start = System.nanoTime();

	public long duration() {
		return NANOSECONDS.toMillis(System.nanoTime() - start);
	}

	public static long duration(Runnable test) {
		Timer timer = new Timer();
		test.run();
		return timer.duration();
	}
}
