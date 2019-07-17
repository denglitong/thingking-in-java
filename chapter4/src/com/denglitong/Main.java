package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/16 21:12
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        for (int i : arr) {
            System.out.println(i);
        }

        // 生命标签
        boolean hasContinuedLabel = false;
        label1:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(j + " ");
                if (j >= i) {
                    break ;
                }
            }
            System.out.println();
            if (i == 3) {
                hasContinuedLabel = true;
                continue label1; // 跳回标签处重新开始
            }
            if (hasContinuedLabel) {
                break label1;
            }
        }
        System.out.println("label continue finished");

        System.out.println(OptType.init.getClass()); // class com.denglitong.OptType
        System.out.println(OptType.init.getNumber());
        System.out.println(OptType.init.getName());
        System.out.println(OptType.class); // class com.denglitong.OptType
    }
}
