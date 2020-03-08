package leetcode.test;

/**
 * 验证 回文串
 */
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int length = s.length();
        int tail = length - 1;
        for (int i = 0; i < length && tail >= 0; i++, tail--) {
            char h1 = s.charAt(i);
            while (!check(h1) && i <= tail && i < length-1) {
                i++;
                h1 = s.charAt(i);
            }
            char h2 = s.charAt(tail);
            while (!check(h2) && i <= tail&&tail>=1) {
                tail--;
                h2 = s.charAt(tail);
            }
            if (i >= tail) {
                return true;
            }
            if (h1 != h2) {
                return false;
            }

        }
        return true;
    }

    private boolean check(char ch) {
        if ('0' <= ch && ch <= '9') {
            return true;
        }
        if ('a' <= ch && ch <= 'z') {
            return true;
        }
        if ('A' <= ch && ch <= 'Z') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        boolean palindrome = a.isPalindrome(".,");
        System.out.println(palindrome);
    }
}