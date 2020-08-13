package leetcode.other;

import java.util.LinkedList;
import java.util.List;

class Solution443 {
    public String multiply(String num1, String num2) {
        List<String> stringList = new LinkedList<>();
        int b = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {

            char a = num2.charAt(i);
            String temp = mul(num1, a, b);
            stringList.add(temp);
            b = b + 1;
        }

        String a = stringList.get(0);
        for (int i = 1; i < stringList.size(); i++) {
            a = add(a, stringList.get(i));
        }
        return a;
    }

    private String mul(String num1, char a, int c) {
        if (a - '0' == 0 || num1.equals("0")) {
            return "0";
        }
        int temp = 0;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < c; i++) {
            s.append(0);
        }
        char[] chs = num1.toCharArray();
        for (int i = chs.length - 1; i >= 0; i--) {
            char b = chs[i];
            int numA = a - '0';
            int numB = b - '0';
            temp = numA * numB + temp;
            s.insert(0, temp % 10);
            temp = temp / 10;
        }
        if (temp != 0) {
            s.insert(0, temp);
        }
        return s.toString();
    }

    private String add(String num1, String num2) {
        char[] chs1;
        char[] chs2;
        if (num2.length() >= num1.length()) {
            chs2 = num2.toCharArray();
            chs1 = num1.toCharArray();
        } else {
            chs1 = num2.toCharArray();
            chs2 = num1.toCharArray();
        }
        int temp = 0;
        StringBuilder s = new StringBuilder();

        int chs_l1 = chs1.length - 1;
        int chs_l2 = chs2.length - 1;
        while (chs_l1 >= 0 && chs_l2 >= 0) {
            int a = chs1[chs_l1] - '0';
            int b = chs2[chs_l2] - '0';
            int r = a + b + temp;
            if (r >= 10) {
                s.insert(0, r - 10);
                temp = 1;
            } else {
                s.insert(0, r);
                temp = 0;
            }
            chs_l1--;
            chs_l2--;
        }
        while (chs_l2 >= 0) {
            int b = chs2[chs_l2] - '0';
            int r = b + temp;
            if (r >= 10) {
                s.insert(0, r - 10);
                temp = 1;
            } else {
                s.insert(0, r);
                temp = 0;
            }
            chs_l2--;
        }
        if (temp != 0) {
            s.insert(0, temp);
        }
        return s.toString();
    }


    public static void main(String[] args) {
        String a = "0";
        String b = "52";
        Solution443 solution443 = new Solution443();
        System.out.println(solution443.multiply(a, b));
    }
}