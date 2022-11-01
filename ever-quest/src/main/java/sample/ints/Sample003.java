package sample.ints;

import java.util.Arrays;

public class Sample003 {
    public static void main(String[] args) {
        int[] bit32 = new int[32];
        int n1 = 100;
        System.out.println(Integer.toBinaryString(n1));  // 1100100
        // 00000000000000000000000001100100
        for (int i = 0; i < 32; i++) {
            bit32[i] =  n1 >> (31 - i) & 1;
        }
        // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0]
        System.out.println(Arrays.toString(bit32));

        int result = 0;
        for (int i = 0; i < 32; i++) {
            System.out.println(result);
            System.out.println(result << 1);
            result = (result << 1) + bit32[i] % 3;
        }
        System.out.println(result);
    }

    public static int singleNumber(int[] nums) {
        int[] bit32 = new int[32];
        for (int num: nums
             ) {
            for (int i = 0; i < 32; i++) {
                bit32[i] +=  num >> (31 - i) & 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + bit32[i] % 3;
        }
        return result;
    }
}
