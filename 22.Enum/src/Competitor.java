/**
 * @author denglitong
 * @date 2021/1/24
 */
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}