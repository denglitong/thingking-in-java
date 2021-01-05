/**
 * @autor denglitong
 * @date 2019/9/13
 */
class NeedsCleanup {
    private static long counter = 1;
    private final long id = counter++;
    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}

class ConstructorException extends Exception {}
class NeedsCleanup2 extends NeedsCleanup {
    // construction can fail
    NeedsCleanup2() throws ConstructorException {}
}

public class CleanupIdiom {
    public static void main(String[] args) {
        NeedsCleanup nc1 = new NeedsCleanup();
        try {
            //
        } finally {
            nc1.dispose();
        }
        // if construction cannot fail, you can group objects:
        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {
            //
        } finally {
            nc3.dispose(); // reverse order of construction
            nc2.dispose();
        }
        // if construction can fail you must guard each one:
        try {
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try {
                //
            } finally {
                // 如果 dispose() 可以抛出异常，那么还需要额外的 try 语句块
                // 基本上，你应该仔细考虑所有的可能性并确保正确处理每一种情况
                nc4.dispose();
            }
        } catch (ConstructorException e) {
            System.out.println(e);
        }
    }
}
