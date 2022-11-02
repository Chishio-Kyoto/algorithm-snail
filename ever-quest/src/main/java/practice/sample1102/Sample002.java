package practice.sample1102;

public class Sample002 {
    public static void main(String[] args) {
        String s1 = "11", s2 = "10";
        String result = addBinary(s1, s2);
        System.out.println(result);
    }

    public static String addBinary(String s1, String s2) {

        StringBuilder result = new StringBuilder();

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            // 从右往左依次取值
            int digitA = i >= 0 ? s1.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? s2.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum == 2 ? 1 : 0;
            sum = sum >= 2 ? sum-2 : sum;
            result.append(sum);
        }
        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}
