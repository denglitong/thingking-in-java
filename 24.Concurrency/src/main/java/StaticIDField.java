/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/21
 */
public class StaticIDField implements HasID {
	private static int counter = 0;
	private int id = counter++;

	@Override
	public int getID() {
		return id;
	}
}
