package practice.sample1117;

public class Sample002 {
    public static void main(String[] args) {
        // 任何数异或自身的值为0
        System.out.println(10 ^ 10);

        String str1 = "0101";
        int[] ints1 = new int[str1.length()];
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            ints1[i] = str1.charAt(i) - '0';
        }
        for (int t: ints1) {
            result = (result << 1) + t;
        }
        System.out.println(result);
        int i1 = 1 << 30;
        System.out.println(i1);
    }
}
