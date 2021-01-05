import java.util.Iterator;

/**
 * @autor denglitong
 * @date 2019/8/22
 */
class PetSequence {
    protected Pet[] pets = Pets.list(8).toArray(new Pet[0]);
}

/**
 * 生成Iterator是将序列与消费该序列的方法连接在一起耦合度最小的方式
 */
public class NonCollectionSequence extends PetSequence {
    public Iterator<Pet> iterator() {
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
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceIterator.display(nc.iterator());
    }
}
