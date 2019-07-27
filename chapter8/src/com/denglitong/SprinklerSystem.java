package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/25
 */
public class SprinklerSystem {

    private String value1, value2, value3, value4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        return "value1 = " + value1 + " " +
                "value2 = " + value2 + " " +
                "value3 = " + value3 + " " +
                "value4 = " + value4 + " \n" +
                "i = " + i + " " + "f = " + f + " " +
                "souce = " + source;
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklers = new SprinklerSystem();
        System.out.println(sprinklers);
    }

}
