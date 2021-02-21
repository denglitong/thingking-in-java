import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java8的lambdas和方法引用可以通过匹配方法签名来使用（结构一致性）
 * 可以传递给 ExecutorService
 *
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/17
 */

class NotRunnable {
	public void go() {
		System.out.println("NotRunnable");
	}
}

class NotCallable {
	public Integer get() {
		System.out.println("NotCallable");
		return 1;
	}
}

public class LambdasAndMethodReferences {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.submit(() -> System.out.println("Lambda1"));
		exec.submit(new NotRunnable()::go);
		exec.submit(() -> {
			System.out.println("Lambda2");
			return 1;
		});
		exec.submit(new NotCallable()::get);
		exec.shutdown();
	}
}
