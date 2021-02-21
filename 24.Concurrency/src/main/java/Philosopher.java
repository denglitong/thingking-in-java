/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class Philosopher implements Runnable {
	private final int seat;
	private final StickHolder left, right;

	public Philosopher(int seat, StickHolder left, StickHolder right) {
		this.seat = seat;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "P" + seat;
	}

	@Override
	public void run() {
		while (true) {
			right.pickUp();
			left.pickUp();
			System.out.println(this + " eating");
			right.putDown();
			left.putDown();
		}
	}
}
