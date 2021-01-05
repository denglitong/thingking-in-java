/**
 * @autor denglitong
 * @date 2019/7/27
 */
public class Music {
    public static void tune(Instrument instrument) {
        // 动态绑定/延迟绑定
        instrument.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        Music.tune(flute);
    }
}
