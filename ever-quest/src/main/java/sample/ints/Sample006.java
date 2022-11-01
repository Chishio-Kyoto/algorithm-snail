package sample.ints;

public class Sample006 {
    public static void main(String[] args) {
        int i1 = Integer.valueOf("0101",2);  // 5
        int i2 = Integer.valueOf("1010",2);  // 10
        int i3 = Integer.valueOf("1001", 2);  // 9

        System.out.println(i1 & i1);  // 5
        System.out.println(i1 & i2);  // 0
        System.out.println(i1 & i3);  // 1
        System.out.println(i2 & i3);  // 8

        System.out.println(i1 | i1);  // 5
        System.out.println(i1 | i2);  // 15
        System.out.println(i1 | i3);  // 13
        System.out.println(i2 | i3);  // 11

        System.out.println(0 | 1);  // 1
        System.out.println(0 | 1 | 2 | 4 | 16);  // 23
        System.out.println(0 | 1 | 2 | 3 | 5);  // 7
    }
}
