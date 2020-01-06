package leetcode.tanxin;

/**
 * 加油站
 * 1.总和 大于等于 0
 * 2.
 * 1 3 2 2 1
 */
class Solution1 {
    public int candy(int[] ratings) {
        if (ratings.length == 0 && ratings.length == 1) {
            return ratings.length;
        }
        boolean flag = false;//用来判断是否在倒叙中
        int s = 0;
        int sum = 0;
        int last = 0; int i;
        for (i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                last = last + 1;
                if (flag) {
                    flag = false;
                    sum = sum + (i - s + 2) * (i - s + 1) / 2;
                    last = 1;
                } else {
                    sum = sum + last;
                }
            } else if (ratings[i] == ratings[i + 1]) {
                if(flag){
                    sum = sum + (i - s + 2) * (i - s + 1) / 2;
                    flag = true;
                }else{
                    flag = true;
                    s = i;
                }
            } else {
                if (!flag) {
                    flag = true;
                    s = i;
                }
            }
        }
        if (flag) {
            sum = sum + (i - s + 2) * (i - s + 1) / 2;
        } else {
            sum = sum + last;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution1 a = new Solution1();
        int[] b = {1, 2, 2,2};
        System.out.println(a.candy(b));
    }
}