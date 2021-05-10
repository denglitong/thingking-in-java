import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * 责任链模式：在链序列中的每个策略都试图满足这个调用，直到有一个策略满足或达到链序列的末尾
 *
 * @author litong.deng@foxmail.com
 * @date 2021/5/10
 */
class Result {
    boolean success;
    List<Double> line;

    public Result(List<Double> line) {
        success = true;
        this.line = line;
    }

    public Result() {
        success = false;
        line = Collections.emptyList();
    }
}

class Fail extends Result {}

interface Algorithm {
    Result algorithm(List<Double> line);
}

class FindMinima3 {
    public static Result leastSquares(List<Double> line) {
        System.out.println("LeaseSquares.algorithm");
        boolean weSucceed = false;
        if (weSucceed) {
            return new Result(Arrays.asList(1.1, 2.2));
        } else {
            return new Fail();
        }
    }

    public static Result perturbation(List<Double> line) {
        System.out.println("Perturbation.algorithm");
        boolean weSucceed = false;
        if (weSucceed) {
            return new Result(Arrays.asList(3.3, 4.4));
        } else {
            return new Fail();
        }
    }

    public static Result bisection(List<Double> line) {
        System.out.println("Bisection.algorithm");
        boolean weSucceed = true;
        if (weSucceed) {
            return new Result(Arrays.asList(5.5, 6.6));
        } else {
            return new Fail();
        }
    }

    // 算法列表，即"链"
    static List<Function<List<Double>, Result>> algorithms = Arrays.asList(
            FindMinima3::leastSquares,
            FindMinima3::perturbation,
            FindMinima3::bisection
    );

    public static Result minima(List<Double> line) {
        for (Function<List<Double>, Result> algorithm : algorithms) {
            Result result = algorithm.apply(line);
            if (result.success) {
                return result;
            }
        }
        return new Fail();
    }
}

public class ChainOfResponsibility {
    public static void main(String[] args) {
        FindMinima3 solver = new FindMinima3();
        List<Double> line = Arrays.asList(
                1.0, 2.0, 1.0, 2.0, -1.0,
                3.0, 4.0, 5.0, 4.0
        );
        // Result result = solver.minima(line);
        Result result = FindMinima3.minima(line);
        if (result.success) {
            System.out.println(result.line);
        } else {
            System.out.println("No algorithm found");
        }
    }
}
