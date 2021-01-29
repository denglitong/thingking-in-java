import java.util.EnumSet;

/**
 * @author denglitong
 * @date 2021/1/24
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(AlarmPoints.BATHROOM);
        System.out.println(points);

        points.addAll(EnumSet.of(
                AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        System.out.println(points);

        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(
                AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        System.out.println(points);

        points.removeAll(
                EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
        System.out.println(points);

        // 补集
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}
