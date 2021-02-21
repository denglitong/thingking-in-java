import com.dlt.Timer;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class OnePizza {
	public static void main(String[] args) {
		Pizza za = new Pizza(0);
		System.out.println(Timer.duration(() -> {
			while (!za.complete()) {
				za.next();
			}
		}));
	}
}
