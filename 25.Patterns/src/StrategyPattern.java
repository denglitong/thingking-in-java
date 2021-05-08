import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * 策略模式
 * 策略模式看起来像从同一个积累继承而来的一系列 命令 类；
 * 使用命令模式是为了解决特定问题，而将变化的部分分离到函数对象中；
 * 而策略模式的灵活性在运行时才会体现出来；
 * <p>
 * 尽管如此，这种区别却是非常模糊的
 *
 * @author litong.deng@foxmail.com
 * @date 2021/5/8
 */

// the common strategy base type:
class FindMinima {
    Function<List<Double>, List<Double>> algorithm;
}

// the various strategies:
class LeastSquares extends FindMinima {
    public LeastSquares() {
        algorithm = (line) -> Arrays.asList(1.1, 2.2);
    }
}

class Perturbation extends FindMinima {
    public Perturbation() {
        algorithm = (line) -> Arrays.asList(3.3, 4.4);
    }
}

class Bisection extends FindMinima {
    public Bisection() {
        algorithm = (line) -> Arrays.asList(5.5, 6.6);
    }
}

class MinimaSolver {
    private FindMinima strategy;

    public MinimaSolver(FindMinima strategy) {
        this.strategy = strategy;
    }

    List<Double> minima(List<Double> line) {
        return strategy.algorithm.apply(line);
    }

    void changeAlgorithm(FindMinima newAlgorithm) {
        strategy = newAlgorithm;
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        MinimaSolver solver = new MinimaSolver(new LeastSquares());
        List<Double> line = Arrays.asList(
                1.0, 2.0, 1.0, 2.0, -1.0,
                3.0, 4.0, 5.0, 4.0
        );
        System.out.println(solver.minima(line));
        solver.changeAlgorithm(new Perturbation());
        System.out.println(solver.minima(line));
        solver.changeAlgorithm(new Bisection());
        System.out.println(solver.minima(line));
    }
}
