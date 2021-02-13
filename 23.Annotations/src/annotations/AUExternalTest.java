package annotations;

/**
 * 通过继承可以简单的达到一个非嵌入式的测试
 *
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/8
 */
public class AUExternalTest extends AtUnitExample1 {
	@Test
	boolean _MethodOne() {
		return methodOne().equals("This is methodOne");
	}

	@Test
	boolean _MethodTwo() {
		return methodTwo() == 2;
	}
}
