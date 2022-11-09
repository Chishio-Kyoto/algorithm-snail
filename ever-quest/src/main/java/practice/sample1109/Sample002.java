package practice.sample1109;

public class Sample002 {

    public static void main(String[] args) {
        String a = "1010";
        String b = "100010010";
        Solution solution = new Solution();
        String result = solution.addBinary(a, b);
        System.out.println(result);
    }

     static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder result = new StringBuilder();
            int aLength = a.length();
            int bLength = b.length();
            int i = aLength - 1, j = bLength - 1;
            int carry = 0;
            while (i >= 0 || j >= 0) {
                int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
                int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
                int sum = digitA + digitB + carry;
                carry = sum >= 2 ? 1 : 0;
                sum = sum >= 2 ? sum-2 : sum;
                result.append(sum);
            }
            if (carry == 1) {
                result.append(1);
            }
            return result.reverse().toString();
        }
    }
}
