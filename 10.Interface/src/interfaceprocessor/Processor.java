package interfaceprocessor;

/**
 * @autor denglitong
 * @date 2019/7/31
 */
public interface Processor {

    default String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input);

}
