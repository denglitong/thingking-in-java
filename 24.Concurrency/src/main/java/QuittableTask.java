import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/17
 */
public class QuittableTask implements Runnable {
	final int id;

	public QuittableTask(int id) {
		this.id = id;
	}

	private AtomicBoolean running = new AtomicBoolean(true);

	public void quit() {
		running.set(false);
	}

	@Override
	public void run() {
		while (running.get()) {
			new Nap(0.1);
		}
		System.out.print(id + " ");
	}
}
