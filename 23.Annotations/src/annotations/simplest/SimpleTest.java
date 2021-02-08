package annotations.simplest;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/8
 */
@Simple
public class SimpleTest {
	@Simple
	int i;

	@Simple
	public SimpleTest() {
	}

	@Simple
	public void foo() {
		System.out.println("simplest.SimpleTest.foo()");
	}

	@Simple
	public void bar(String s, int i, float f) {
		System.out.println("simplest.SimpleTest.bar()");
	}

	@Simple
	public static void main(String[] args) {
		@Simple
		SimpleTest st = new SimpleTest();
		st.foo();
	}
}
