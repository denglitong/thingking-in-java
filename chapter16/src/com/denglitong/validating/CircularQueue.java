package com.denglitong.validating;

import java.util.Arrays;

/**
 * @autor denglitong
 * @date 2019/9/15
 */
public class CircularQueue {
    private Object[] data;
    private int in = 0; // next available storage space
    private int out = 0; // next gettable object
    // has it wrapped around the circular queue?
    private boolean wrapped = false;

    public CircularQueue(int size) {
        data = new Object[size];
        assert invariant();
    }

    public boolean empty() {
        return !wrapped && in == out;
    }

    public boolean full() {
        return wrapped && in == out;
    }

    public boolean isWrapped() {
        return wrapped;
    }

    public void put(Object item) {
        precondition(item != null, "put() null item");
        precondition(!full(), "put() into full CircularQueue");
        assert invariant();
        data[in++] = item;
        if (in >= data.length) {
            in = 0;
            wrapped = true;
        }
        assert invariant();
    }

    public Object get() {
        precondition(!empty(), "get() from empty CircularQueue");
        assert invariant();
        Object returnVal = data[out];
        data[out] = null;
        out++;
        if (out >= data.length) {
            out = 0;
            wrapped = false;
        }
        assert postcondition(returnVal != null, "Null item in CircularQueue");
        return returnVal;
    }

    // design-by-contract support methods:
    private static void precondition(boolean cond, String msg) {
        if (!cond) {
            throw new CircularQueueException(msg);
        }
    }

    private static boolean postcondition(boolean cond, String msg) {
        if (!cond) {
            throw new CircularQueueException(msg);
        }
        return true;
    }

    private boolean invariant() {
        // gurantee that no null values are in the region of 'data'
        // that holds objects:
        for (int i = out; i != in; i = (i + 1) % data.length) {
            if (data[i] == null) {
                throw new CircularQueueException(
                        "non-null outside of CircularQueue range: " + dump());
            }
        }
        return true;
    }

    public String dump() {
        return "in = " + in +
                ", out = " + out +
                ", full() = " + full() +
                ", empty() = " + empty() +
                ", CircularQueue = " + Arrays.asList(data);
    }

}
