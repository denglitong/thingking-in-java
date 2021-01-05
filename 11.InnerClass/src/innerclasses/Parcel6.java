package innerclasses;

/**
 * 在任意的作用域下嵌入一个内部类：
 * @autor denglitong
 * @date 2019/8/4
 */
public class Parcel6 {
    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;
                public TrackingSlip(String id) {
                    this.id = id;
                }
                String getSlip() { return id; }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
        // can't use it here, out of scope:
        // TrackingSlip ts = new TrackingSlip("x");
    }

    public void track() { internalTracking(true); }

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}
