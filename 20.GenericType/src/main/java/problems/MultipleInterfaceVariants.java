package problems;

/**
 * @author denglitong
 * @date 2021/1/20
 */
interface Payable<T> {}

class Employee implements Payable<Employee> {}

// 编译错误，因为泛型擦除使得 Payable<Employee> 和 Payable<Hourly> 简化为相同的类 Payable
// class Hourly extends Employee implements Payable<Hourly> {}

public class MultipleInterfaceVariants {
}
