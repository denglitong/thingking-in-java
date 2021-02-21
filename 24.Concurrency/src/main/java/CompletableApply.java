import com.dlt.Timer;

import java.util.concurrent.CompletableFuture;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/17
 */
public class CompletableApply {
	public static void main(String[] args) {
		CompletableFuture<Machina> cf = CompletableFuture.completedFuture(
				new Machina(0));
		CompletableFuture<Machina> cf2 = cf.thenApply(Machina::work);
		CompletableFuture<Machina> cf3 = cf2.thenApply(Machina::work);
		CompletableFuture<Machina> cf4 = cf3.thenApply(Machina::work);
		CompletableFuture<Machina> cf5 = cf4.thenApply(Machina::work);

		// chained
		Timer timer = new Timer();
		cf = CompletableFuture.completedFuture(new Machina(99))
				// 阻塞返回
				.thenApply(Machina::work)
				.thenApply(Machina::work)
				.thenApply(Machina::work)
				.thenApply(Machina::work);
		System.out.println(timer.duration());
	}
}
