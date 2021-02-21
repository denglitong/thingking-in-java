/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/16
 */
public class InterferingTask implements Runnable {
	final int id;
	// Runnable 没有返回值，只能使用副作用产生结果 - 操纵换充值而不是返回结果
	// 而 Callable<T> 可以返回任务结果
	private static Integer val = 0;

	public InterferingTask(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			val++;
		}
		System.out.println(id + " " +
				Thread.currentThread().getName() + " " + val);
	}
}
