package leetcode.dynamic;


/**
 * 普通dp
 */
public class Solution91 {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        //int[] res = new int[len];
        if (len == 0) {
            return 0;
        }
        if (chars[0] == '0')
            return 0;
        int res = chars[0] > '2' ? 1 : 0;
        int last_num = chars[0] <= '2' ? 1 : 0;

        for (int i = 1; i < len; i++) {
            if (chars[i] == '0') {
                if (last_num == 0) {
                    return 0;
                } else {
                    res = last_num;
                    last_num = 0;
                }
            } else if (chars[i] >= '7') {
                res = chars[i - 1] == '1' ? res + last_num * 2 : res + last_num;
                last_num = 0;
            } else if (chars[i] >= '3') {
                res = res + last_num * 2;
                last_num = 0;
            } else {
                int temp = res;
                res = last_num;
                last_num = last_num + temp;
            }
        }
        return res + last_num;
    }

    public static void main(String[] args) {
        Solution91 solution = new Solution91();
        //int[][] a = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        //Assert.assertEquals("10", solution.numDecodings("10"), 1);
        //Assert.assertEquals("100", solution.numDecodings("100"), 0);
        //Assert.assertEquals("01", solution.numDecodings("01"), 0);
        //Assert.assertEquals("11", solution.numDecodings("11"), 2);
        //Assert.assertEquals("17", solution.numDecodings("17"), 2);
        //Assert.assertEquals("27", solution.numDecodings("27"), 1);
        //Assert.assertEquals("112", solution.numDecodings("112"), 3);
        //Assert.assertEquals("172", solution.numDecodings("172"), 2);
    }
}