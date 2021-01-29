/**
 * @author denglitong
 * @date 2021/1/24
 */
public enum OvverideConstantSpecific {
    NUT, BOLT,
    WSHER {
        @Override
        void f() {
            System.out.println("Overridden method");
        }
    };

    void f() {
        System.out.println("default behavior");
    }

    public static void main(String[] args) {
        for (OvverideConstantSpecific ocs : values()) {
            System.out.print(ocs + ": ");
            ocs.f();
        }
    }
}
