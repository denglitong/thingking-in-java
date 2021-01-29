import java.util.stream.Stream;

/**
 * @author denglitong
 * @date 2021/1/24
 */
public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT,
    CRUISER, BATTLESHIP, MOTHERSHIP;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        Stream.of(SpaceShip.values())
                .forEach(System.out::println);
    }
}
