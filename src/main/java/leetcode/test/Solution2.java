package leetcode.test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 分割回文串
 */
class Solution2 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        if (s.length() == 0) {
            return res;
        }
        Deque<String> temp = new LinkedList<>();
        doPartition(s, 0, res, temp);

        return res;

    }

    private void doPartition(String s, int start, List res, Deque temp) {
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (!checkPalindrome(s, start,  i)) {
                continue;
            }
            temp.addLast(s.substring(start,  i + 1));
            doPartition(s,  i + 1, res, temp);
            temp.removeLast();

        }
    }

    /**
     * 判断是否是回文
     *
     * @param str
     * @param left
     * @param right
     * @return
     */
    private boolean checkPalindrome(String str, int left, int right) {
        // 严格小于即可
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution2 a = new Solution2();
        List<List<String>> palindrome = a.partition("aab");
        System.out.println(palindrome);
    }
}