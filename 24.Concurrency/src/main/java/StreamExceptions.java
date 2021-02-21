import java.util.stream.Stream;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class StreamExceptions {

	static Stream<Breakable> test(String id, int failCount) {
		return Stream.of(new Breakable(id, failCount))
				.map(Breakable::work)
				.map(Breakable::work)
				.map(Breakable::work)
				.map(Breakable::work);
	}

	public static void main(String[] args) {
		// no operations are even applied...
		test("A", 1);
		test("B", 2);
		Stream<Breakable> c = test("C", 3);
		test("D", 4);
		test("E", 5);
		// stream exception will occur until there's a terminal operation:
		System.out.println("Entering try");
		try {
			c.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
