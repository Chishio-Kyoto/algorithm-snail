package practice.sample1104;

public class sample01 {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            // System.out.println(Integer.toBinaryString(i));
            // System.out.println(Integer.toBinaryString(1 << i));
            System.out.println(Integer.toBinaryString(40 & (1 << i)));
        }

        System.out.println("@@@@@@@@@@");

        int m = 40;
        System.out.println(Integer.toBinaryString(m));
        for (int j = 0; j < 9; j++) {
            // System.out.println(Integer.toBinaryString(m >> j));
            // System.out.println(Integer.valueOf(Integer.toBinaryString(m >> j), 2));
            System.out.println(Integer.toBinaryString(1 & (m >> j)));
        }
    }
}
