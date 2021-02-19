import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/16
 */
public class Futures {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		Future<Integer> f = exec.submit(new CountingTask(99));
		// 当任务未完成时调用get()会阻塞至调用完成
		// 不推荐使用 Java5 的 Future，它只能解决等待任务完成才暴露问题
		// 推荐使用 Java8的 CompletableFuture
		System.out.println(f.get());
		exec.shutdown();
	}
}
