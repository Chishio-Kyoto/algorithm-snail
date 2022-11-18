package practice.sample1117;

import java.util.Arrays;

public class Sample001 {
    public static void main(String[] args) {
        int i1 = Integer.valueOf("0101", 2);
        int i2 = 5;
        int i3 = Integer.valueOf("5", 16);

        System.out.printf("%d %d %d\n", i1, i2, i3);

        System.out.println(Integer.toBinaryString(i2));
        System.out.println(Integer.toHexString(i2));

        String str1 = "100101010101";
        int[] ints1 = new int[str1.length()];
        for (int i = str1.length()-1; i >= 0; i--) {
            int temp = str1.charAt(i) - '0';
            ints1[str1.length() - i - 1] = temp;
        }
        System.out.println(Arrays.toString(ints1));
    }
}
