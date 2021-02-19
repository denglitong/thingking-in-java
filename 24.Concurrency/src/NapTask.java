/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/14
 */
public class NapTask implements Runnable {
	final int id;

	public NapTask(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		new Nap(0.1);
		System.out.println(this + " " + Thread.currentThread().getName());
	}

	@Override
	public String toString() {
		return "NapTask[" + id + "]";
	}
}
