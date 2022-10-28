package sample.ints;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        int[] result = countBits(10);
        System.out.println(Arrays.toString(result));

        for (int i = 1; i <= 10; i++) {
            System.out.println(Integer.toBinaryString(i));
            System.out.println("@@ " + Integer.toBinaryString(i & (i-1)));
        }
    }

    public static int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            while (j != 0) {
                result[i]++;
                j = j & (j-1);
            }
        }
        return result;
    }
}
