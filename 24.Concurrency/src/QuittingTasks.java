import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/17
 */
public class QuittingTasks {
	public static final int COUNT = 150;

	public static void main(String[] args) {
		// ExecutorService exec = Executors.newCachedThreadPool();
		// List<QuittableTask> tasks = IntStream.range(1, COUNT)
		// 		.mapToObj(QuittableTask::new)
		// 		.peek(exec::execute)
		// 		.collect(Collectors.toList());
		// new Nap(1);
		// tasks.forEach(QuittableTask::quit);
		// exec.shutdown();

		// CompletableFuture
		List<QuittableTask> tasks = IntStream.range(1, COUNT)
				.mapToObj(QuittableTask::new)
				.collect(Collectors.toList());
		List<CompletableFuture<Void>> cFutures = tasks.stream()
				.map(CompletableFuture::runAsync)
				.collect(Collectors.toList());
		new Nap(1);
		tasks.forEach(QuittableTask::quit);
		cFutures.forEach(CompletableFuture::join);
	}
}
