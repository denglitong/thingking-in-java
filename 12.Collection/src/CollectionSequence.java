import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * @autor denglitong
 * @date 2019/8/22
 */
public class CollectionSequence extends AbstractCollection<Pet> {
    private Pet[] pets = Pets.list(8).toArray(new Pet[0]);

    @Override
    public int size() {
        return pets.length;
    }

    @Override
    public Iterator<Pet> iterator() {
        // 此处的棱形语法不能推断出要返回的Iterator的类型
        // 所以棱形语法仍然非常有限
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        InterfaceIterator.display(c);
        InterfaceIterator.display(c.iterator());
    }
}
