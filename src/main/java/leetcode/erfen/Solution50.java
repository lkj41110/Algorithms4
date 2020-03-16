package leetcode.erfen;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution50 {
    public double myPow(double x, int n) {
        if (n > 0) {
            x = 1 / x;
            n = -n;
        }
        return p(x, n);
    }

    private double p(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = p(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }


    public String compressString(String S) {
        if (S.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char last = S.charAt(0);
        int num = 1;
        for (int i = 1; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == last) {
                num++;
            } else {
                sb.append(last).append(num);
                last = ch;
                num = 1;
            }
        }
        sb.append(last).append(num);
        return sb.toString().length()>=S.length()?S:sb.toString();
    }


    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        String aabcccccaa = solution50.compressString("");
        System.out.println(aabcccccaa);
    }

















}