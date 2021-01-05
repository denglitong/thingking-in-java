/**
 * 抛出异常的时候，异常就近处理，找到匹配的处理程序之后，它就认为异常将得到处理
 * 然后就不再继续查找
 *
 * @autor denglitong
 * @date 2019/9/13
 */
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

public class Human {
    public static void main(String[] args) {
        // catch the exact type:
        try {
            throw new Sneeze();
        } catch (Sneeze e) {
            System.out.println("Caught Sneeze");
        } catch (Annoyance e) {
            System.out.println("Caught Annoyance");
        }

        // catch the base type:
        try {
            throw new Sneeze();
        } catch (Annoyance e) {
            // Annoyance 会捕获 Annoyance 以及所有从它派生的异常
            System.out.println("Caught Annoyance");
        }

        // 捕获基类的 catch 字句放在最前面，派生类的异常在后面，
        // 这样编译器会发现 Sneeze 的 catch 子句用于得不到执行，会报错
        // try {
        //     throw new Sneeze();
        // } catch (Annoyance e) {
        //     //
        // } catch (Sneeze e) {
        //
        // }
    }
}
