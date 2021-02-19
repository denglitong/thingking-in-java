import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/14
 */
public class CachedThreadPool {
	public static void main(String[] args) {
		// 每个任务都有自己的线程，并行运行
		ExecutorService exec = Executors.newCachedThreadPool();
		IntStream.range(0, 10)
				.mapToObj(NapTask::new)
				.forEach(exec::submit);
		exec.shutdown();
	}
}
