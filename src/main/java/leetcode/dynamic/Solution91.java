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

}