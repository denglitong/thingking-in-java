import java.util.concurrent.TimeUnit;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/14
 */
public class Nap {
	public Nap(double t) {
		try {
			TimeUnit.MILLISECONDS.sleep((long) (1000 * t));
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public Nap(double t, String msg) {
		this(t);
		System.out.println(msg);
	}
}
