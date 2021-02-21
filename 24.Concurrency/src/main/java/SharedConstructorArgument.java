import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
interface ShardArg {
	int get();
}

class Unsafe implements ShardArg {
	private int i = 0;

	@Override
	public int get() {
		return i++;
	}
}

class Safe implements ShardArg {
	private static AtomicInteger counter = new AtomicInteger();

	@Override
	public int get() {
		return counter.getAndIncrement();
	}
}

class SharedUser implements HasID {
	private final int id;

	public SharedUser(ShardArg sa) {
		this.id = sa.get();
	}

	@Override
	public int getID() {
		return id;
	}
}

public class SharedConstructorArgument {
	public static void main(String[] args) {
		Unsafe unsafe = new Unsafe();
		IDChecker.test(() -> new SharedUser(unsafe));

		Safe safe = new Safe();
		IDChecker.test(() -> new SharedUser(safe));
	}
}
