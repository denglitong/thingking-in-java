package annotations.atunit;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/13
 */
public class DemoProcessFiles {
	public static void main(String[] args) {
		new ProcessFiles(file -> System.out.println(file), "java")
				.start(args);
	}
}
