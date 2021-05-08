import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author litong.deng@foxmail.com
 * @date 2021/5/8
 */
class Findminima2 {
    Function<List<Double>, List<Double>> algorithm;

    public Findminima2() {
        leastSquares(); // default
    }

    // the various strategy
    // 封装了不同的算法，也包含了上下文，方便在一个单独的类中控制策略的选择
    void leastSquares() {
        algorithm = (line) -> Arrays.asList(1.1, 2.2);
    }

    void perturbation() {
        algorithm = (line) -> Arrays.asList(3.3, 4.4);
    }

    void bitsection() {
        algorithm = (line) -> Arrays.asList(5.5, 6.6);
    }

    List<Double> minima(List<Double> line) {
        return algorithm.apply(line);
    }
}

public class StrategyPattern2 {
    public static void main(String[] args) {
        Findminima2 solver = new Findminima2();
        List<Double> line = Arrays.asList(
                1.0, 2.0, 1.0, 2.0, -1.0,
                3.0, 4.0, 5.0, 4.0
        );
        System.out.println(solver.minima(line));
        solver.perturbation();
        System.out.println(solver.minima(line));
        solver.bitsection();
        System.out.println(solver.minima(line));
    }
}
