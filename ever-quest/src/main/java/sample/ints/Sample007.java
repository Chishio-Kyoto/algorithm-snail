package sample.ints;

import java.util.Arrays;

public class Sample007 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        // 5的二进制、十进制、十六进制初始化
        int i1 = Integer.valueOf("0101",2);
        int i2 = 5;
        int i3 = Integer.valueOf("5", 16);
        System.out.printf("%d, %d, %d", i1, i2, i3);
        System.out.println();

        // 十进制转二进制、转十六进制
        System.out.println(Integer.toBinaryString(i2));
        System.out.println(Integer.toHexString(i2));

        // 装箱、拆箱
        Integer I1 = Integer.valueOf("0101",2);
        int i4 = I1.intValue();
        System.out.println(i4);

        // 将字母映射为数字
        String s1 = "abcdefghijklmn";
        int[] ints1 = new int[s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            int t = s1.charAt(i) - 'a';
            ints1[i] = t;
        }
        System.out.println(Arrays.toString(ints1));
    }
}
