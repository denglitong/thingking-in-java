package com.denglitong.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor denglitong
 * @date 2019/8/5
 */
public class Controller {
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event e) {
        eventList.add(e);
    }

    public void run() {
        while (eventList.size() > 0) {
            // make a copy so you're not modifying the list while you're selecting the elements in it
            // 在目前的设计中只是遍历、执行action、然后删除，当时并不知道Event要做什么
            // 这正是此设计的关键所在-"使变化的事物与不变的事物相互分离"，而你可以通过创建不同的Event子类来表现不同的行为
            // 这正是内部类要做的事情，内部类允许：
            // 1.控制框架的完整实现是由单个的类创建的，从而使得实现的细节不被封装了起来。内部类用来表示解决问题所必须的各种不同的action()
            // 2.内部类能够很容易的访问任何外围类的任意成员，这会让实现不同action()变得灵活
            for (Event e : new ArrayList<>(eventList)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }

        // use iterator
        // Exception in thread "main" java.util.ConcurrentModificationException...
        // Iterator<Event> it = eventList.iterator();
        // while (it.hasNext()) {
        //     Event e = it.next();
        //     System.out.println(e);
        //     e.action();
        //     it.remove();
        // }
    }
}
