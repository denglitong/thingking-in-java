import java.util.*;

/**
 * @autor denglitong
 * @date 2019/8/24
 */
public class MultiIterableClass extends IterableClass {
    public Iterable<String> reversed() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int current = words.length - 1;
                    @Override
                    public boolean hasNext() {
                        return current >= 0;
                    }
                    @Override
                    public String next() {
                        return words[current--];
                    }
                };
            }
        };
    }

    public Iterable<String> randomized() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                // 注意这里用了一个新的list然后把这个list打乱顺序再返回
                // 如何直接对Arrays.asList(words)进行打乱那么它将修改words的底层数组
                List<String> shuffled = new ArrayList<>(Arrays.asList(words));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        MultiIterableClass mic = new MultiIterableClass();
        for (String s : mic.reversed()) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : mic.randomized()) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : mic) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
