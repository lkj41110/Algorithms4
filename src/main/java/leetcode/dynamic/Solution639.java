package leetcode.dynamic;//package leetcode.dynamic;
//
//import org.junit.Assert;
//
///**
// * 普通dp
// */
//public class Solution639 {
//    public int numDecodings(String s) {
//        char[] chars = s.toCharArray();
//        int len = chars.length;
//        //int[] res = new int[len];
//        if (len == 0) {
//            return 0;
//        }
//        if (chars[0] == '0')
//            return 0;
//        int res = 0;
//        int last_num_1 = 0;
//        int last_num_2 = 0;
//        if (chars[0] == '*') {
//            res = 7;
//            last_num_1 = 1;
//            last_num_2 = 1;
//        } else if (chars[0] == '1') {
//            res = 0;
//            last_num_1 = 1;
//            last_num_2 = 0;
//        }else if()
//
//
//        for (int i = 1; i < len; i++) {
//
//        }
//        return res + last_num;
//    }
//
//    public static void main(String[] args) {
//        Solution639 solution = new Solution639();
//        //int[][] a = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
//        Assert.assertEquals("10", solution.numDecodings("10"), 1);
//        Assert.assertEquals("100", solution.numDecodings("100"), 0);
//        Assert.assertEquals("01", solution.numDecodings("01"), 0);
//        Assert.assertEquals("11", solution.numDecodings("11"), 2);
//        Assert.assertEquals("17", solution.numDecodings("17"), 2);
//        Assert.assertEquals("27", solution.numDecodings("27"), 1);
//        Assert.assertEquals("112", solution.numDecodings("112"), 3);
//        Assert.assertEquals("172", solution.numDecodings("172"), 2);
//    }
//}