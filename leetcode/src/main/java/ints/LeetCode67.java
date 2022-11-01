package ints;

public class LeetCode67 {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        Solution solution = new Solution();
        String result = solution.addBinary(a, b);
        System.out.println(result);
    }

    static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder stringBuilder = new StringBuilder();
            int i = a.length()-1;
            int j = b.length()-1;
            int carry = 0;
            while (i >= 0 || j >= 0) {
                int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
                int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
                int sum = digitA + digitB + carry;
                carry = sum >= 2 ? 1 : 0;
                sum = sum >= 2 ? sum - 2 : sum;
                stringBuilder.append(sum);
            }

            if (carry == 1) {
                stringBuilder.append(1);
            }
            return stringBuilder.reverse().toString();
        }
    }
}
