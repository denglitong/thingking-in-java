package com.denglitong.collections;

import java.util.Map;

/**
 * @autor denglitong
 * @date 2019/8/23
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        // Map.Entry is Set, which implement Iterable that can used in for-in
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
