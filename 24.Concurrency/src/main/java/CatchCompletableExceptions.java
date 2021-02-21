/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class CatchCompletableExceptions {
	static void handleException(int failCount) {
		// call the Function only if there's an exception,
		// must produce same type as came in:
		CompletableExceptions.test("exceptionally", failCount)
				.exceptionally((ex) -> {
					if (ex == null) {
						System.out.println("I don't get it yet");
					}
					return new Breakable(ex == null ? "OK" : ex.getMessage(), 0);
				})
				.thenAccept(str -> System.out.println("result: " + str));

		// create a new result (recover):
		CompletableExceptions.test("handle", failCount)
				.handle((result, fail) -> {
					if (fail != null) {
						return "Failure recovery object";
					} else {
						return result + " is good";
					}
				})
				.thenAccept(s -> System.out.println("result: " + s));

		// do something but pass the same result through:
		CompletableExceptions.test("whenComplete", failCount)
				.whenComplete((result, fail) -> {
					if (fail != null) {
						System.out.println("It failed");
					} else {
						System.out.println(result + "OK");
					}
				})
				.thenAccept(breakable -> System.out.println("result: " + breakable));
	}

	public static void main(String[] args) {
		System.out.println("**** Failure Mode ****");
		handleException(2);
		System.out.println("**** Success Mode ****");
		handleException(0);
	}
}
