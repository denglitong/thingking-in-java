import com.dlt.Timer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/14
 */
public class ParallelPrime {
	static final int Count = 100000;

	public static boolean isPrime(long n) {
		return LongStream.rangeClosed(2, (long) Math.sqrt(n)).noneMatch(i -> n % i == 0);
	}

	public static void main(String[] args) throws IOException {
		Timer timer = new Timer();
		List<String> primes = LongStream.iterate(2, i -> i + 1)
				.parallel()
				.filter(ParallelPrime::isPrime)
				.limit(Count)
				.mapToObj(Long::toString)
				.collect(Collectors.toList());
		System.out.println(timer.duration());
		Files.write(Paths.get("primes.txt"), primes, StandardOpenOption.CREATE);

		// LongStream.rangeClosed(2, 4).forEach(System.out::println); // 2 3 4
		// LongStream.iterate(2, i -> i + 1).limit(3).forEach(System.out::println); // 2 3 4
		// LongStream.iterate(2, i -> i + 2).limit(3).forEach(System.out::println); // 2 4 6
	}
}
