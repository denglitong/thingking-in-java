package com.denglitong.interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * 适配器模式：你可以以这种方式在已有类中增加新接口，
 * 这意味着一股接受接口类型的方法提供了一种让任何类都可以与该方法进行适配的方式。
 * 这就是使用接口而不是类的强大之处（只有你实现了这个接口，就能在任意接口声明的地方代替它）
 *
 * @autor denglitong
 * @date 2019/8/3
 */
public class AdapterRandomDoubles implements RandomDoubles, Readable {
    private int count;

    public AdapterRandomDoubles(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) {
            return -1;
        }
        String result = Double.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdapterRandomDoubles(7));
        while (s.hasNextDouble()) {
            System.out.println(s.nextDouble() + " ");
        }
    }
}
