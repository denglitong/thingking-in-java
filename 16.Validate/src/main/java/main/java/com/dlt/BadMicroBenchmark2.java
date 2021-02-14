package main.java.com.dlt;

import java.util.Arrays;
import java.util.Random;
import java.util.SplittableRandom;

/**
 * @author denglitong
 * @date 2021/1/5
 */
public class BadMicroBenchmark2 {
	static final int SIZE = 5_000_000;

	public static void main(String[] args) {
		long[] la = new long[SIZE];
		Random r = new Random();

		System.out.println("parallelSetAll: " +
				Timer.duration(() -> Arrays.parallelSetAll(la, n -> r.nextLong())));
		System.out.println("setAll: " +
				Timer.duration(() -> Arrays.setAll(la, n -> r.nextLong())));

		// SplittableRandom 是为并行算法设计的，比普通的 Random 在资源竞争方面表现更好
		SplittableRandom sr = new SplittableRandom();
		System.out.println("parallelSetAll: " +
				Timer.duration(() -> Arrays.parallelSetAll(la, n -> sr.nextLong())));
		System.out.println("setAll: " +
				Timer.duration(() -> Arrays.setAll(la, n -> sr.nextLong())));
	}
}
