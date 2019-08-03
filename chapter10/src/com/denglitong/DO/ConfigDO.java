package com.denglitong.DO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @autor denglitong
 * @date 2019/8/3
 */
public class ConfigDO {
    @Override
    public String toString() {
        super.toString();
        return "ConfigDO{}";
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("start");
        for (int i = 0; i < 100; i++) {
            sb.append("hello");
        }
        System.out.println(sb.toString());

        List<String> list = new ArrayList<>();
        list.add("guban");
        list.add("bao");
        String[] array = list.toArray(new String[0]);
        System.out.println(array.length);
        for (String a : array) {
            System.out.println(a);
        }
        for (String a : list) {
            System.out.println(a);
        }

        // 不要在foreach中删除，remove请使用Iterator方式，如果并发操作还需要对删除对象加锁
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        // for (String item : list1) {
        //     // "1".equals() 删除成功，结果符合预期
        //     // "2".equals() 删除失败，报错 ConcurrentModificationException
        //     // if ("1".equals(item)) {
        //     if ("2".equals(item)) {
        //         list1.remove(item);
        //     }
        // }
        // System.out.println(list1);
        Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("2".equals(item)) {
                iterator.remove();
            }
        }
        System.out.println(list1);

        // diamond方式
        HashMap<String, String> userCache = new HashMap<>();
        // 全省略方式
        ArrayList<ConfigDO> configDOArrayList = new ArrayList();
        configDOArrayList.add(new ConfigDO());
        configDOArrayList.add(new ConfigDO());
        System.out.println(configDOArrayList.size());
        configDOArrayList.get(0).toString();

    }
}
