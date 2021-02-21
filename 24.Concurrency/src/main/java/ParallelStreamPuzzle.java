import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/14
 */
public class ParallelStreamPuzzle {
	static class IntGenerator implements Supplier<Integer> {
		private int current = 0;

		@Override
		public Integer get() {
			return current++;
		}
	}

	public static void main(String[] args) {
		List<Integer> x = Stream.generate(new IntGenerator())
				.limit(10)
				.parallel()
				.collect(Collectors.toList());
		System.out.println(x);
		//     parallel: [0, 9, 11, 12, 13, 15, 17, 18, 19, 21]
		// not parallel: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
	}
}
