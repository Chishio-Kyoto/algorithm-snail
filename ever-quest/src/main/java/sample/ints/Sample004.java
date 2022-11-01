package sample.ints;

public class Sample004 {
    public static void main(String[] args) {
        String[] strings = new String[] {
              "abcw", "foo", "bar", "fxyz",
                "abcdef"
        };
        int result = maxProduct(strings);
        System.out.println(result);
    }

    public static int maxProduct(String[] words) {
        boolean[][] flags = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char c: words[i].toCharArray()
                 ) {
                // c - 'a' 的取值范围为0～25
                flags[i][c-'a'] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    if (flags[i][k] && flags[j][k]) {
                        break;
                    }
                }
                // 对比完成，计算对应长度的乘积，并最终求出最大乘积值
                if (k == 26) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }
        return result;
    }
}
