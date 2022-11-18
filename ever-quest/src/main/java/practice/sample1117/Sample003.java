package practice.sample1117;

public class Sample003 {
    public static void main(String[] args) {
        int[] flags = new int[4];
        String str1 = "abcd";
        String str2 = "abcf";
        String str3 = "eg";
        for (int i = 0; i < 4; i++) {
            System.out.println(str1.charAt(i) - 'a');
            flags[i] = flags[i] | (str1.charAt(i) - 'a');
            System.out.println(flags[i]);
        }
    }
}
