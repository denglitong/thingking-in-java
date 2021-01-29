/**
 * 优雅与清晰很重要
 *
 * @author denglitong
 * @date 2021/1/24
 */
public enum RoShamBo6 implements Competitor<RoShamBo6> {
    PAPER, SCISSORS, ROCK;

    // 表驱动模式
    private static Outcome[][] table = {
            {Outcome.DRAW, Outcome.LOSE, Outcome.WIN},
            {Outcome.WIN, Outcome.DRAW, Outcome.LOSE},
            {Outcome.LOSE, Outcome.WIN, Outcome.DRAW},
    };

    @Override
    public Outcome compete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 20);
    }
}
