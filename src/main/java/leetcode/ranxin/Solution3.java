package leetcode.ranxin;


import java.util.LinkedList;

/**
 * 1234567
 * <p>
 * 1 219, 3 4
 * 10200  1 200
 * 4132
 */
class Solution3 {
    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        LinkedList a = new LinkedList();
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < chars.length; i++) {
            if (k == 0) {
                break;
            }

            while (k > 0 && a.size() >= 0) {
                if (a.size() == 0) {
                    a.add(chars[i]);
                    break;
                } else {
                    char peek = (char) a.getLast();
                    if (peek <= chars[i]) {
                        a.add(chars[i]);
                        break;
                    } else {
                        a.pollLast();
                        k--;
                        if(k==0){
                            a.add(chars[i]);
                            break;
                        }
                    }
                }
            }
        }
        while (a.size() > k) {
            sb.append(a.poll());
        }
        for (; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        String minResult = sb.toString();

        int i1 = 0;
        while (i1 < minResult.length() && minResult.charAt(i1) == '0') {
            i1++;
        }

        String result = minResult.substring(i1, minResult.length());
        return result.equals("") ? "0" : result;
    }

    public static void main(String[] args) {
        Solution3 a = new Solution3();
        //int[] b = {2, 3, 1, 1, 4};
        System.out.println(a.removeKdigits("9", 1));
        System.out.println(a.removeKdigits("1234567890", 8));
        System.out.println(a.removeKdigits("1432219", 3));
        System.out.println(a.removeKdigits("10200", 1));
    }
}