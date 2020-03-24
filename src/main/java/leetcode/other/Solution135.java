package leetcode.other;


/**
 *
 */
public class Solution135 {

    public int threeSum(int[] ratings) {

//1 5  5 5 4 3 2 1
        int la = 0;
        int la2 = 0;

        int flag = 0; //三种状态
        int res = 0;

        int flag2 = 0;

        if (ratings.length == 0 || ratings.length == 1) {
            return ratings.length;
        }
        for (int i = 0; i < ratings.length; i++) {
            if (flag == 0) {
                if (i - 1 >= 0) {
                    if (ratings[i] > ratings[i - 1]) {
                        la = 2;
                        flag = 1;
                        flag2 = 0;
                    } else if (ratings[i] < ratings[i - 1]) {
                        la2 = 2;
                        flag = 2;
                        flag2 = 0;

                    } else if (ratings[i] == ratings[i - 1]) {
                        res += 1;
                        la = 0;
                        la2 = 0;
                        flag = 0;
                        flag2 = 0;

                    }
                }
            } else if (flag == 1) {
                if (ratings[i] > ratings[i - 1]) {
                    la++;
                } else if (ratings[i] < ratings[i - 1]) {
                    la2 = 2;
                    flag = 2;
                } else if (ratings[i] == ratings[i - 1]) {
                    res = res + res(la, la2, flag2);
                    la = 0;
                    la2 = 0;
                    flag = 0;
                }
            } else {
                if (ratings[i] > ratings[i - 1]) {
                    res = res + res(la, la2, flag2);
                    la = 2;
                    la2 = 0;
                    flag = 1;
                    flag2 = 1;

                } else if (ratings[i] < ratings[i - 1]) {
                    la2++;
                } else if (ratings[i] == ratings[i - 1]) {
                    res = res + res(la, la2, flag2);
                    la = 0;
                    la2 = 0;
                    flag = 0;
                    flag2 = 0;
                }
            }

        }
        res = res + res(la, la2, flag2);

        if (flag == 0) {
            res += 1;
        }
        return res;
    }

    private int res(int a, int b, int flag) {
        int res = 0;
        //a = flag == 1 ? a - 1 : a;
        int max = a > b ? a : b;
        int min = a > b ? b : a;
        res += (1 + max) * max / 2;
        if (min == 0) {
            return flag == 0 ? res : res - 1;
        } else {
            min = min - 1;
        }
        res += (1 + min) * min / 2;
        return flag == 0 ? res : res - 1;
    }

    public static void main(String[] args) {
        //AgentDriverServiceImplTest test = new AgentDriverServiceImplTest();
        //System.out.println(test.test(new int[]{1, 2, 3}) + "  =" + 6);
        //System.out.println(test.test(new int[]{1, 1}) + "  =" + 2);
        //System.out.println(test.test(new int[]{1, 2, 3, 2}) + "  =" + 7);
        //System.out.println(test.test(new int[]{1, 2, 3, 3}) + "  =" + 7);
        //System.out.println(test.test(new int[]{10, 6, 1, 1, 2, 3}) + "  =" + 12);
        //System.out.println(test.test(new int[]{10, 6, 1, 2, 3}) + "  =" + 11);
        //System.out.println(test.test(new int[]{10, 6, 1, 2, 3, 2, 1}) + "  =" + 14);
    }

}