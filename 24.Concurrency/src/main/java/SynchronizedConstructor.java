/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class SynchronizedConstructor {
	public static void main(String[] args) {
		Unsafe unsafe = new Unsafe();
		// 0 unsafe + synchronized -> safe
		IDChecker.test(() -> new SyncConstructor(unsafe));
	}
}
