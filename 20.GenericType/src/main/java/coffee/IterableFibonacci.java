package coffee;

import java.util.Iterator;

/**
 * 适配器（Adapter）模式，通过继承+实现接口
 *
 * @author denglitong
 * @date 2021/1/18
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n;
    public IterableFibonacci(int n) {
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }
            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.get();
            }
        };
    }

    public static void main(String[] args) {
        for (Integer i : new IterableFibonacci(18)) {
            System.out.print(i + " ");
        }
    }
}
