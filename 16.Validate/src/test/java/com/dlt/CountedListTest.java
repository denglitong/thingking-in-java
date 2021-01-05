package com.dlt;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @autor denglitong
 * @date 2019/9/14
 */
public class CountedListTest {
    private CountedList list;

    public CountedListTest() {
        System.out.println("Constructor");
    }
    // 任何其他测试操作之前只运行一次的方法，该方法必须是静态的
    @BeforeAll
    static void beforeAllMsg() {
        System.out.println(">>> Starting CountedListTest");
    }

    // 任何其他测试操作之后只运行一次的方法，该方法必须是静态的
    @AfterAll
    static void afterAllMsg() {
        System.out.println(">>> Finished CountedListTest");
    }

    // 通常用于创建和初始化公共对象，在每次测试前运行的方法
    // 可以将所有这样的初始化放在test类的构造函数中
    // JUnit为每个测试创建一个对象，确保测试运行之前没有副作用
    @BeforeEach
    public void initialize() {
        list = new CountedList();
        System.out.println("Set up for " + list.getId());
        for (int i = 0; i < 3; i++) {
            list.add(Integer.toString(i));
        }
    }

    // 如果你必须在每次测试后执行清理，那就用 @AfterEach
    @AfterEach
    public void cleanup() {
        System.out.println("Cleaning up " + list.getId());
    }

    @Test
    public void insert() {
        System.out.println("Running testInsert()");
        assertEquals(list.size(), 3);
        list.add(1, "Insert");
        assertEquals(list.size(), 4);
        assertEquals(list.get(1), "Insert");
    }

    @Test
    public void replace() {
        System.out.println("Running testReplace()");
        assertEquals(list.size(), 3);
        list.set(1, "Replace");
        assertEquals(list.size(), 3);
        assertEquals(list.get(1), "Replace");
    }

    // a helper to simplify the code. As long as
    // it's not annotated with @Test, it will not be automatically
    // executed by JUnit
    public void compare(List<String> lst, String[] strs) {
        assertArrayEquals(lst.toArray(new String[0]), strs);
    }

    @Test
    public void order() {
        System.out.println("Running testOrder()");
        compare(list, new String[]{"0", "1", "2"});
    }

    @Test
    public void remove() {
        System.out.println("Running testRemove()");
        assertEquals(list.size(), 3);
        list.remove(1);
        assertEquals(list.size(), 2);
        compare(list,new String[]{"0","2"});
    }

    @Test
    public void addAll() {
        System.out.println("Running testAddAll()");
        list.addAll(Arrays.asList(new String[]{
                "An", "African", "Swallow"
        }));
        assertEquals(list.size(), 6);
        compare(list, new String[]{"0","1","2","An","African","Swallow"});
    }

}
