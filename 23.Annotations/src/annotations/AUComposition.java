package annotations;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/8
 */
public class AUComposition {
	AtUnitExample1 testObject = new AtUnitExample1();

	@Test
	boolean tMethodOne() {
		return testObject.methodOne().equals("This is methodOne");
	}

	@Test
	boolean tMethodTwo() {
		return testObject.methodTwo() == 2;
	}
}
