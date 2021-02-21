import com.dlt.Timer;

import java.util.stream.IntStream;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class PizzaParallelSteps {
	static final int QUANTITY = 5;

	public static void main(String[] args) {
		Timer timer = new Timer();

		IntStream.range(0, QUANTITY)
				.mapToObj(Pizza::new)
				.parallel()
				.map(Pizza::roll)
				.map(Pizza::sauce)
				.map(Pizza::cheese)
				.map(Pizza::toppings)
				.map(Pizza::bake)
				.map(Pizza::slice)
				.map(Pizza::box)
				.forEach(System.out::println);

		System.out.println(timer.duration());
	}
}
