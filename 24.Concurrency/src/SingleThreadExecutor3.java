import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/16
 */
public class SingleThreadExecutor3 {
	public static void main(String[] args) {
		// SingleThreadExecutor 一次运行一个task，这些task不会相互干扰
		// 这叫线程封闭
		ExecutorService exec = Executors.newSingleThreadExecutor();
		IntStream.range(0, 10)
				.mapToObj(InterferingTask::new)
				.forEach(exec::execute);
		exec.shutdown();
	}
}
