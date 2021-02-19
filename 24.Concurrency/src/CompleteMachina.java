import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/17
 */
public class CompleteMachina {
	public static void main(String[] args) {
		// 返回一个已经完成的Future<Value>，所以调用get()永远不会阻塞
		CompletableFuture<Machina> cf = CompletableFuture.completedFuture(
				new Machina(0));
		try {
			Machina m = cf.get();
			System.out.println(m);
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}
}
