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


}