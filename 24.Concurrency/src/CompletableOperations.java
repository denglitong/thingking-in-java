import java.util.concurrent.CompletableFuture;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/19
 */
public class CompletableOperations {
	static CompletableFuture<Integer> cfi(int i) {
		return CompletableFuture.completedFuture(Integer.valueOf(i));
	}

	public static void main(String[] args) {
		CompletableUtilities.showr(cfi(1));
		CompletableUtilities.voidr(cfi(2).runAsync(() ->
				System.out.println("runAsync")));
		CompletableUtilities.voidr(cfi(3).thenRunAsync(() ->
				System.out.println("thenRunAsync")));
		CompletableUtilities.voidr(CompletableFuture.runAsync(() ->
				System.out.println("runAsync is static")));
		// 值提供
		CompletableUtilities.showr(CompletableFuture.supplyAsync(() -> 99));

		// 值传递/消费
		CompletableUtilities.voidr(cfi(4).thenAcceptAsync(i ->
				System.out.println("thenAcceptAsync: " + i)));
		CompletableUtilities.showr(cfi(5).thenApplyAsync(i -> i + 42));
		CompletableUtilities.showr(cfi(6).thenComposeAsync(i -> cfi(i + 99)));

		CompletableFuture<Integer> c = cfi(7);
		c.obtrudeValue(111);
		CompletableUtilities.showr(c);

		CompletableUtilities.showr(cfi(8));
		CompletableUtilities.showr(cfi(8).toCompletableFuture());

		c = new CompletableFuture<>();
		c.complete(9);
		CompletableUtilities.showr(c);

		c = new CompletableFuture<>();
		c.cancel(true);
		System.out.println("cancelled: " + c.isCancelled());
		System.out.println("completed exceptionally: " + c.isCompletedExceptionally());
		System.out.println("done: " + c.isDone());
		System.out.println(c);

		c = new CompletableFuture<>();
		System.out.println(c.getNow(777));

		c = new CompletableFuture<>();
		c.thenApplyAsync(i -> i + 42)
				.thenApplyAsync(i -> i * 12);
		// 依赖该cf为前置任务的其他任务数量
		System.out.println("dependents: " + c.getNumberOfDependents()); // 1
		c.thenApplyAsync(i -> i / 2);
		System.out.println("dependents: " + c.getNumberOfDependents()); // 2
	}
}
