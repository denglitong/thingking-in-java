import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class DiningPhilosophers {
	private StickHolder[] sticks;
	private Philosopher[] philosophers;

	public DiningPhilosophers(int n) {
		sticks = new StickHolder[n];
		Arrays.setAll(sticks, i -> new StickHolder());
		philosophers = new Philosopher[n];
		Arrays.setAll(philosophers, i -> new Philosopher(i, sticks[i], sticks[(i + 1) % n]));
		// philosophers[1] = new Philosopher(0, sticks[0], sticks[1]);
		Arrays.stream(philosophers)
				.forEach(CompletableFuture::runAsync);
	}

	public static void main(String[] args) {
		new DiningPhilosophers(5);
		new Nap(3, "Shutdown");
	}
}
