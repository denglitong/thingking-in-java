import java.util.stream.IntStream;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/16
 */
public class CountingStream {
	public static void main(String[] args) {
		System.out.println(
				IntStream.range(0, 10)
						.parallel()
						.mapToObj(CountingTask::new)
						.map(ct -> {
							try {
								return ct.call();
							} catch (Exception e) {
								e.printStackTrace();
								return 0;
							}
						})
						.reduce(0, Integer::sum)
		);
	}
}
