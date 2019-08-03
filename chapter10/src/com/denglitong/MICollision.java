package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/29
 */

interface Bob1 {

    default void bob() {
        System.out.println("Bob1::bob");
    }

}

interface Bob2 {

    default void bob() {
        System.out.println("Bob2::bob");
    }

}

/**
 * error: class Bob inherits unrelated defaults for bob() from types Bob1 and Bob2
 */
// class Bob implements Bob1, Bob2 {
//
// }

interface Sam1 {

    default void sam() {
        System.out.println("Sam1::sam");
    }

}

interface Sam2 {

    default void sam(int i) {
        System.out.println(i * 2);
    }

}

/**
 * This works because the argument list are distinct
 */
class Sam implements Sam1, Sam2 {

}

interface Max1 {

    default void max() {
        System.out.println("Max1::max");
    }

}

interface Max2 {

    default int max() {
        return 47;
    }

}

/**
 * error: types Max2 and Max1 are imcompatible both define max(),
 * but with unrelated return types
 */
// class Max implements Max1, Max2 {
//
//     @Override
//     public void max() {
//         //
//     }
//
// }

public class MICollision {

}
