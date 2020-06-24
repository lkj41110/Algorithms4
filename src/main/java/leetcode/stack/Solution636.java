package leetcode.stack;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution636 {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        if (n == 0) {
            return res;
        }
        Stack<Integer[]> stack = new Stack<>();
        // id  e  value
        for (String l : logs) {
            String[] cmd = l.split(":");

            if (cmd[1].equals("start")) {
                //入队
                if (stack.size() != 0) {
                    Integer[] pop = stack.peek();
                    pop[2] = pop[2] + Integer.valueOf(cmd[2]) - pop[1];
                    pop[1] = Integer.valueOf(cmd[2]);
                }
                stack.push(new Integer[]{Integer.valueOf(cmd[0]), Integer.valueOf(cmd[2]), 0});
            } else if (cmd[1].equals("end")) {
                Integer[] pop = stack.pop();
                res[pop[0]] = res[pop[0]] + pop[2] + Integer.valueOf(cmd[2]) - pop[1] + 1;

                if (stack.size() == 0) {
                    //return res;
                    continue;
                }
                Integer[] pop1 = stack.peek();
                pop1[1] = Integer.valueOf(cmd[2]) + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution636 s = new Solution636();
        int[] ints = s.exclusiveTime(1, Arrays.asList(new String[]{"0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"}));
    }

}