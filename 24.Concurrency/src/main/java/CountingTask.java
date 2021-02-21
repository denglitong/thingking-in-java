import java.util.concurrent.Callable;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/16
 */
public class CountingTask implements Callable<Integer> {
	final int id;

	public CountingTask(int id) {
		this.id = id;
	}

	@Override
	public Integer call() throws Exception {
		Integer val = 0;
		for (int i = 0; i < 100; i++) {
			val++;
		}
		System.out.println(id + " " + Thread.currentThread().getName() + " " + val);
		return val;
	}
}
