import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/16
 */
public class CachedThreadPool2 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		IntStream.range(0, 10)
				.mapToObj(InterferingTask::new)
				.forEach(exec::execute);
		exec.shutdown();
	}
}
