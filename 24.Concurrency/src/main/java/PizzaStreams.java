import com.dlt.Timer;

import java.util.stream.IntStream;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class PizzaStreams {
	static final int QUANTITY = 5;

	public static void main(String[] args) {
		Timer timer = new Timer();
		/**
		 * 当很容易把数据分解成相同的、易于处理的各个部分时，使用并行流方法处理最为合适
		 */
		IntStream.range(0, QUANTITY)
				.mapToObj(Pizza::new)
				// 并行流加速制作多个的时间
				.parallel()
				.forEach(za -> {
					while (!za.complete()) {
						za.next();
					}
				});
		System.out.println(timer.duration());
	}
}
