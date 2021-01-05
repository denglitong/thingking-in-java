package com.dlt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @autor denglitong
 * @date 2019/9/15
 */
public class CircularQueueTest {
    private CircularQueue queue = new CircularQueue(10);
    private int i = 0;

    @BeforeEach
    public void initialize() {
        while (i < 5) {
            queue.put(Integer.toString(i++));
        }
    }

    // helper methods:
    private void showFullness() {
        Assertions.assertTrue(queue.full());
        Assertions.assertFalse(queue.empty());
        System.out.println(queue.dump());
    }

    private void showEmptiness() {
        Assertions.assertFalse(queue.full());
        Assertions.assertTrue(queue.empty());
        System.out.println(queue.dump());
    }

    @Test
    public void full() {
        System.out.println("testFull");
        System.out.println(queue.dump());
        System.out.println(queue.get());
        System.out.println(queue.get());
        while (!queue.full()) {
            queue.put(Integer.toString(i++));
        }
        String msg = "";
        try {
            queue.put("");
        } catch (CircularQueueException e) {
            msg = e.getMessage();
            System.out.println(msg);
        }
        Assertions.assertEquals("put() into full com.denglitong.CircularQueue", msg);
        showFullness();
    }

    @Test
    public void empty() {
        System.out.println("testEmpty");
        while (!queue.empty()) {
            System.out.println(queue.get());
        }
        String msg = "";
        try {
            queue.get();
        } catch (CircularQueueException e) {
            msg = e.getMessage();
            System.out.println(msg);
        }
        Assertions.assertEquals("get() from empty com.denglitong.CircularQueue", msg);
        showEmptiness();
    }

    @Test
    public void nullPut() {
        System.out.println("testNullPut");
        String msg = "";
        try {
            queue.put(null);
        } catch (CircularQueueException e) {
            msg = e.getMessage();
            System.out.println(msg);
        }
        Assertions.assertEquals("put() null item", msg);
    }

    @Test
    public void testCircularity() {
        System.out.println("testCircularity");
        while (!queue.full()) {
            queue.put(Integer.toString(i++));
        }
        showFullness();
        Assertions.assertTrue(queue.isWrapped());

        while (!queue.empty()) {
            System.out.println(queue.get());
        }
        showEmptiness();

        while (!queue.full()) {
            queue.put(Integer.toString(i++));
        }
        showFullness();

        while (!queue.empty()) {
            System.out.println(queue.get());
        }
        showEmptiness();
    }

}
