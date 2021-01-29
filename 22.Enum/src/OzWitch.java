/**
 * @author denglitong
 * @date 2021/1/24
 */
public enum OzWitch {
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby " +
            "Splippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");

    private String desc;

    private OzWitch(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + ": " + witch.getDesc());
        }
    }
}
