import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class GuardedIDField implements HasID {
	private static AtomicInteger counter = new AtomicInteger();
	private int id = counter.getAndIncrement();

	@Override
	public int getID() {
		return id;
	}

	public static void main(String[] args) {
		IDChecker.test(GuardedIDField::new);
	}
}
