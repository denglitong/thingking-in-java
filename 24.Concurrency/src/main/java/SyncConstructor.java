/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class SyncConstructor implements HasID {
	private final int id;
	private static Object constructorLock = new Object();

	public SyncConstructor(ShardArg sa) {
		synchronized (constructorLock) {
			id = sa.get();
		}
	}

	@Override
	public int getID() {
		return id;
	}
}
