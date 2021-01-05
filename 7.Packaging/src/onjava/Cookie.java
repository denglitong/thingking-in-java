package onjava;

/**
 * @autor denglitong
 * @date 2019/7/24
 */
public class Cookie {

    public Cookie() {
        System.out.println("Cookie constructor");
    }

    private void bite() {
        System.out.println("bite private");
    }

    // protected 权限除了继承类可见外，在包内也是可见的
    protected void bite2() {
        System.out.println("bite protected");
    }

}

class ChocolateChip extends Cookie {

    public ChocolateChip() {
        System.out.println("ChocolateChip constructor");
    }

    public void chomp() {
        // bite();
        bite2();
    }

    public static void main(String[] args) {
        ChocolateChip x = new ChocolateChip();
        x.chomp();
    }

}