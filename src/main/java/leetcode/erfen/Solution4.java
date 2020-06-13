//package leetcode.erfen;
//
///**
// * Definition for singly-linked list.
// * public class ListNode {
// * int val;
// * ListNode next;
// * ListNode(int x) { val = x; }
// * <p>
// * 翻转求最小值
// * }
// */
//class Solution4 {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//
//        int size = len1 + len2;
//
//        int l1_s = 0;
//        int l2_s = 0;
//        while (size == ((len1 + len2) % 2 == 0 ? 2 : 1)) {
//            int mid = size / 2;
//            if (nums1[l1_s + mid] >= nums2[l2_s + mid]) {
//
//                l2_s = l2_s + mid;
//            }else{
//                l1_s = l2_s + mid;
//            }
//            size = size - mid;
//        }
//        return (len1 + len2) % 2 == 0?:(nums1[l1_s]+nums2[l2_s])/2:
//    }
//
//
//    //public static void main(String[] args) {
//    //    int a[] = {2, 1};
//    //    Solution4 solution = new Solution4();
//    //    System.out.println(solution.findMin(a));
//    //}
//}