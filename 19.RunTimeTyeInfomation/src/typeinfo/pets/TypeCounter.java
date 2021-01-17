package typeinfo.pets;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author denglitong
 * @date 2021/1/17
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> bastType;

    public TypeCounter(Class<?> bastType) {
        this.bastType = bastType;
    }

    public void count(Object obj) {
        Class<?> type = obj.getClass();
        if (!bastType.isAssignableFrom(type)) {
            throw new RuntimeException(obj + " incorrect type: " + type +
                    ", should by type or subtype of " + bastType);
        }
        countClass(type);
    }

    public void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && bastType.isAssignableFrom(superClass)) {
            countClass(superClass);
        }
    }

    @Override
    public String toString() {
        String result = entrySet().stream()
                .map(pair -> String.format("%s=%s",
                        pair.getKey().getSimpleName(),
                        pair.getValue()))
                .collect(Collectors.joining(", "));
        return "{ " + result + " }";
    }
}
