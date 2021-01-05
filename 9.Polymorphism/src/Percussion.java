/**
 * @autor denglitong
 * @date 2019/7/28
 */
public class Percussion extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Percussion.play() " + note);
    }

    @Override
    String what() {
        return "Percussion";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Percussion");
    }
}
