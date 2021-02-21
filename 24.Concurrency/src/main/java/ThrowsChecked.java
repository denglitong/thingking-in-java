import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class ThrowsChecked {

	class Checked extends Exception {
	}

	static ThrowsChecked noChecked(ThrowsChecked tc) {
		return tc;
	}

	static ThrowsChecked withChecked(ThrowsChecked tc) throws Checked {
		return tc;
	}

	static void testStream() {
		Stream.of(new ThrowsChecked())
				.map(ThrowsChecked::noChecked)
				// unhandle exception
				// .map(ThrowsChecked::withChecked)
				.map(tc -> {
					try {
						return withChecked(tc);
					} catch (Checked e) {
						throw new RuntimeException(e);
					}
				});
	}

	static void testCompletableFuture() {
		CompletableFuture.completedFuture(new ThrowsChecked())
				.thenApply(ThrowsChecked::noChecked)
				// unhandle exception
				// .thenApply(ThrowsChecked::withChecked)
				.thenApply(tc -> {
					try {
						return withChecked(tc);
					} catch (Exception e) {
						throw new RuntimeException(e.getMessage());
					}
				});
	}
}
