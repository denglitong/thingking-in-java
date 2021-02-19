import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/16
 */
public class CachedThreadPool3 {
	public static Integer extractResult(Future<Integer> f) {
		try {
			return f.get();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<CountingTask> tasks = IntStream.range(0, 10)
				.mapToObj(CountingTask::new)
				.collect(Collectors.toList());
		// ExecutorService invokeAll 启动集合中每个 Callable，并且在全部执行完成之后才返回
		List<Future<Integer>> futures = exec.invokeAll(tasks);
		Integer sum = futures.stream()
				.map(CachedThreadPool3::extractResult)
				.reduce(0, Integer::sum);
		System.out.println("sum = " + sum);
		exec.shutdown();
	}
}
