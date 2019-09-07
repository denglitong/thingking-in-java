package com.denglitong.streams;

import java.util.ArrayList;

/**
 * @autor denglitong
 * @date 2019/9/7
 */
public class SpecialCollector {
    public static void main(String[] args) throws Exception {
        String filePath = "";
        ArrayList<String> words = FileToWords.stream(filePath)
                .collect(
                        ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll
                );
    }
}
