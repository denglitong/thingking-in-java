import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 首先使它工作，然后使它更快地工作
 * 并行流只是看起来很容易
 * 上下文切换的代价远远超过并行性的任何加速
 * 除非你是专家，否则不要使用 parallel() + limit() 的结合
 *
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/14
 */
public class ParallelStreamPuzzle3 {
	public static void main(String[] args) {
		List<Integer> x = IntStream.range(0, 30)
				.peek(e -> System.out.println(e + ": " + Thread.currentThread().getName()))
				.limit(10)
				.parallel()
				.boxed()
				.collect(Collectors.toList());
		System.out.println(x);
	}
}
