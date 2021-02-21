import java.util.concurrent.CompletableFuture;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class CompletableExceptions {
	static CompletableFuture<Breakable> test(String id, int failcount) {
		return CompletableFuture.completedFuture(new Breakable(id, failcount))
				.thenApply(Breakable::work)
				.thenApply(Breakable::work)
				.thenApply(Breakable::work)
				.thenApply(Breakable::work);
	}

	public static void main(String[] args) {
		test("A", 1);
		test("B", 2);
		test("C", 3);
		test("D", 4);
		test("E", 5);

		System.out.println("************");
		try {
			test("F", 2).get();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			test("F2", 2).join();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(
				// true
				test("G", 2).isCompletedExceptionally()
		);

		System.out.println(
				// true
				test("H", 2).isDone()
		);
		CompletableFuture<Integer> cfi = new CompletableFuture<>();
		// false
		System.out.println("done? " + cfi.isDone());
		// force an exception
		cfi.completeExceptionally(new RuntimeException("forced"));
		try {
			cfi.get();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
