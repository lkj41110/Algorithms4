package leetcode.treearray;

/**
 * @author luokai
 * @description:
 * @date: 2020/8/17
 * @version: 1.0
 */
public class S307 {
    int[] c;
    int n;
    int[] s;

    public S307(int[] nums) {
        n = nums.length;
        this.c = new int[n + 1];
        this.s = new int[n];

        for (int i = 0; i < nums.length; i++) {
            s[i] = nums[i];
            updateBit(i + 1, nums[i]);
        }
    }

    public void update(int i, int val) {
        int temp = val - s[i];
        s[i] = val;
        updateBit(i + 1, temp);
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    private int sum(int i) {
        int res = 0;
        while (i > 0) {
            res += c[i];
            i -= lowBit(i);
        }
        return res;
    }

    private int lowBit(int i) {
        return i & -i;
    }

    public void updateBit(int i, int val) {
        while (i <= n) {
            c[i] += val;
            i += lowBit(i);
        }
    }


    public static void main(String[] args) {
        int[] nums = {7, 2, 7, 2, 0};
        S307 s307 = new S307(nums);
        s307.update(4, 6);
        s307.update(0, 2);
        s307.update(0, 9);
        System.out.println(s307.sumRange(4, 4));
        s307.update(3, 8);
        System.out.println(s307.sumRange(0, 4));
        s307.update(4, 1);
        System.out.println(s307.sumRange(0, 3));
        System.out.println(s307.sumRange(0, 4));
        s307.update(0, 4);


    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}
