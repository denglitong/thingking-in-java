package watercolors;

import java.util.EnumSet;
import java.util.Set;

import static watercolors.Sets.*;
import static watercolors.WaterColors.*;

/**
 * @author denglitong
 * @date 2021/1/18
 */
public class WaterColorSets {
    public static void main(String[] args) {
        Set<WaterColors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<WaterColors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("union(set1, set2): " + union(set1, set2));
        Set<WaterColors> subset = intersection(set1, set2);
        System.out.println("intersection(set1, set2): " + subset);
        System.out.println("difference(set1, subset): " + difference(set1, subset));
        System.out.println("difference(set2, subset): " + difference(set2, subset));
        System.out.println("complement(set1, set2): " + complement(set1, set2));
    }
}
