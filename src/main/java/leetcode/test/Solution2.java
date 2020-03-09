package leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 */
class Solution2 {
    public List<String> letterCombinations(String digits) {
        char a[][] = {{}, {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        List<String> res = new ArrayList<>();
        String str = "";
        if (digits.length() == 0) {
            return res;
        }
        doLetterCombinations(digits, 0, a, res, str);
        return res;
    }

    private static void doLetterCombinations(String str, int start, char a[][], List<String> res, String temp) {
        if (start == str.length()) {
            res.add(temp);
            return;
        }
        int num = str.charAt(start) - '0';
        for (int i = 0; i < a[num].length; i++) {
            temp = temp + a[num][i];
            doLetterCombinations(str, start + 1, a, res, temp);
            temp = temp.substring(0, temp.length() - 1);
        }
    }


    public static void main(String[] args) {
        Solution2 a = new Solution2();
        List<String> palindrome = a.letterCombinations("23");
        System.out.println(palindrome);
    }
}