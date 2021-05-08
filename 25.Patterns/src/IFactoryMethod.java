/**
 * @author litong.deng@foxmail.com
 * @date 2021/5/7
 */
public interface IFactoryMethod {
    // 入参 type 决定要创建哪种类型，这里是 String，但它可以是任何数据集合
    Shape create(String type);
}
