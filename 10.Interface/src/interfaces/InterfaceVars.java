package interfaces;

import java.util.Random;

/**
 * 接口字段 static final
 *
 * @autor denglitong
 * @date 2019/8/3
 */
interface InterfaceVars {
    int
            JANUARY = 1,
            FEBRUARY = 2,
            MARCH = 3,
            APRIL = 4,
            MAY = 5,
            JUNE = 6,
            JULY = 7,
            AUGUSE = 8,
            SEPTEMBER = 9,
            OCTOBER = 10,
            NOVEMBER = 11,
            DECEMBER = 12;
    Random RAND = new Random(47);
    int RANDOM_INT = RAND.nextInt(10);
    long RANDOM_LONG = RAND.nextLong();
    float RANDOM_FLOAT = RAND.nextFloat();
    double RANDOM_DOUBLE = RAND.nextDouble();
}