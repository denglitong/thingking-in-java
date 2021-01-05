package interfaceprocessor;

/**
 * 适配器模式，因为你经常遇到的情况是无法修改类，类库是被发现而不是创建的，
 * 适配器允许代码接受已有的接口产生需要的接口
 *
 * @autor denglitong
 * @date 2019/7/31
 */
class FilterAdapter implements Processor {

    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }

}

public class FilterProcessor {

    public static void main(String[] args) {
        Waveform w = new Waveform();
        Applicator.apply(new FilterAdapter(new LowPass(1.0)), w);
        Applicator.apply(new FilterAdapter(new HighPass(2.0)), w);
        Applicator.apply(new FilterAdapter(new BandPass(3.0, 4.0)), w);
    }

}
