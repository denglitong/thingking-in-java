import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class StickHolder {
	private static class Chopstick {
	}

	private Chopstick stick = new Chopstick();
	private BlockingQueue<Chopstick> holder = new ArrayBlockingQueue<>(1);

	public StickHolder() {
		putDown();
	}

	public void pickUp() {
		try {
			// blocks if unavailable
			holder.take();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public void putDown() {
		try {
			holder.put(stick);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
