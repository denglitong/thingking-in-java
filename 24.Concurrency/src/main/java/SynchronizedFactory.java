/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class SynchronizedFactory {
	public static void main(String[] args) {
		Unsafe unsafe = new Unsafe();
		// 通过同步的静态工厂方法，可以在构造过程中锁定Class对象
		IDChecker.test(() -> SyncFactory.factory(unsafe));
	}
}
