/**
 * @autor denglitong
 * @date 2019/7/27
 */

class Poppet {
    private int i;

    Poppet(int i) {
        this.i = i;
    }
}

public class BlankFinal {
    private final int i = 0;
    private final int j; // blank final
    private final Poppet p; // blank final reference

    // blank finals must be initialize blank final
    public BlankFinal() {
        j = 1;
        p = new Poppet(1);
    }

    // blank final must be initialized in each constructor
    public BlankFinal(int x) {
        j = x;
        p = new Poppet(x);
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}
