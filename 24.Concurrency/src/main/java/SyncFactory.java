/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class SyncFactory implements HasID {
	private final int id;

	// 私有构造器
	private SyncFactory(ShardArg sa) {
		id = sa.get();
	}

	@Override
	public int getID() {
		return id;
	}

	// 同步工厂方法
	public static synchronized SyncFactory factory(ShardArg sa) {
		return new SyncFactory(sa);
	}
}
