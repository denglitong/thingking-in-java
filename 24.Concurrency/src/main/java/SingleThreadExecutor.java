import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.stream.IntStream;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/14
 */
public class SingleThreadExecutor {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		IntStream.range(0, 10)
				.mapToObj(NapTask::new)
				.forEach(exec::execute);
		System.out.println("All tasks submitted");
		exec.shutdown();

		try {
			exec.execute(new NapTask(99));
		} catch (RejectedExecutionException e) {
			System.out.println(e);
		}

		while (!exec.isTerminated()) {
			System.out.println(Thread.currentThread().getName() + " awaiting termination");
			new Nap(0.1);
		}
	}
}
