import com.dlt.Timer;

import java.util.concurrent.CompletableFuture;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/17
 */
public class CompletableApplyAsync {
	public static void main(String[] args) {
		Timer timer = new Timer();
		CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0))
				.thenApplyAsync(Machina::work)
				.thenApplyAsync(Machina::work)
				.thenApplyAsync(Machina::work)
				.thenApplyAsync(Machina::work);
		System.out.println(timer.duration());
		System.out.println(cf.join());
		System.out.println(timer.duration());
	}
}
