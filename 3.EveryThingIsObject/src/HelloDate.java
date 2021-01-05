//: object/HelloDate.java

import java.util.Date;

/**
 * The First Thinking in Java example program.
 * Display a string and today's date.
 * @autor denglitong
 * @date 2019/7/16 20:45
 * @version 0.0.1
 */

public class HelloDate {

    /**
     * Entry point to Class & application
     * @param args array of string arguments
     * @throws exceptions No exceptions thrown
     */
    public static void main(String[] args) {
        System.out.println("Hello, it's: " + new Date());
    }

    /**
     * Say hello to person meeting
     * @param name the name of person you meet
     * @return void
     */
    public static void sayHello(String name) {
        System.out.println("Hello " + name + ", nice to meet you!");
    }
} /* Output: (55% match)
Hello, it's Wed Oct 05 14:39:36 MDT 2005
*///:~
