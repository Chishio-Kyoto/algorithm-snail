package practice.sample1216;

public class Sample {
    public static void main(String[] args) {
        String a = "11", b = "10";
        Solution solution = new Solution();
        String r = solution.addBinary(a, b);
        System.out.println(r);
    }

    static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder r = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;  // 进位变量
            while (i >= 0 || j >= 0) {
                int m = i >= 0 ? a.charAt(i--) - '0' : 0;
                int n = j >= 0 ? b.charAt(j--) - '0' : 0;

                int sum = m + n + carry;
                carry = sum >= 2 ? 1 : 0;
                sum = sum >= 2 ? sum - 2 : sum;

                r.append(sum);
            }

            if (carry == 1) {
                r.append(1);
            }

            return r.reverse().toString();
        }
    }
}
