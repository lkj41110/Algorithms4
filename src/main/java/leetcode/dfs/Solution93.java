package leetcode.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * 深搜
 */
public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new LinkedList<>();
        String str = "";
        dsf(list, 0, 0, s, str);
        return list;
    }

    private void dsf(List<String> list, int index, int sStart, String s, String str) {
        if (index >= 4 || sStart >= s.length()) {
            return;
        }
        int end = sStart;
        while (end <= s.length()) {
            end++;
            String substring = s.substring(sStart, end);
            int a = Integer.valueOf(substring);
            if (a > 255) {
                break;
            }
            //符合答案
            if (s.length() - end > (3 - index) * 3) {
                if (a == 0) {
                    break;
                }
                continue;
            } else if (s.length() - end < (3 - index)) {
                break;
            }

            String temp = "";
            if (index != 0) {
                temp = ".";
            }
            temp += a;
            if (end == s.length() && index == 3) {
                list.add(str + temp);
                break;
            }

            dsf(list, index + 1, end, s, str + temp);

            if (a == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        Solution93 solution93 = new Solution93();
        solution93.restoreIpAddresses("00100");
    }


}