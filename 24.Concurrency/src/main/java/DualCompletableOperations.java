import java.util.concurrent.CompletableFuture;

/**
 * run 和 accept 是终端操作
 * apply 和 combine 则生成新的 payload-bearing(承载负载) 的 CompletableFuture
 * combineAsync 等待两个 CompletableFuture 完成，然后将它们都交给一个 BiFunction
 * 这个BiFunction可以将结果加入到最终的 CompletableFuture 的有效负载中
 *
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class DualCompletableOperations {
	static CompletableFuture<Workable> cfA, cfB;

	static void init() {
		cfA = Workable.make("A", 0.15);
		cfB = Workable.make("B", 0.10);
	}

	static void join() {
		cfA.join();
		cfB.join();
		System.out.println("*************");
	}

	public static void main(String[] args) {
		init();
		CompletableUtilities.voidr(cfA.runAfterEitherAsync(cfB, () ->
				System.out.println("runAfterEither")));
		join();

		init();
		CompletableUtilities.voidr(cfA.runAfterBothAsync(cfB, () ->
				System.out.println("runAfterBoth")));
		join();

		init();
		CompletableUtilities.showr(cfA.applyToEitherAsync(cfB, w -> {
			System.out.println("applyToEither: " + w);
			return w;
		}));
		join();

		init();
		CompletableUtilities.voidr(cfA.acceptEitherAsync(cfB, w -> {
			System.out.println("acceptEither: " + w);
		}));
		join();

		init();
		CompletableUtilities.voidr(cfA.thenAcceptBothAsync(cfB, (w1, w2) -> {
			System.out.println("thenAcceptBoth: " + w1 + ", " + w2);
		}));
		join();

		init();
		CompletableUtilities.showr(cfA.thenCombineAsync(cfB, (w1, w2) -> {
			System.out.println("thenCombine: " + w1 + ", " + w2);
			return w1;
		}));
		join();

		init();
		CompletableFuture<Workable> cfC = Workable.make("C", 0.08);
		CompletableFuture<Workable> cfD = Workable.make("D", 0.09);
		CompletableFuture.anyOf(cfA, cfB, cfC, cfD)
				.thenRunAsync(() -> System.out.println("anyOf"));
		join();
	}
}
