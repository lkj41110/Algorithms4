package leetcode.other;


/**
 * -10  1  2  3  9  10
 */
public class Solution1103 {

    public int[] distributeCandies(int candies, int num_people) {

        int[] res = new int[num_people];
        if (candies == 0) {
            return res;
        }
        int max = (1 + num_people) * num_people / 2;
        int time = -1;
        int temp = candies;
        while (temp > 0 && ++time >= 0) {
            temp = temp - max - time * num_people*num_people;
        }
        if (time > 0) {
            for (int i = 0; i < num_people; i++) {
                res[i] = (i + 1) * time + num_people * (time - 1)*time/2;
                candies = candies - res[i];
            }
        }
        //剩下的糖果
        //candies = candies - max * time;
        int i = 1;
        while (candies > 0) {
            if (candies - i - time * num_people >= 0) {
                res[i - 1] = res[i - 1] + i + time * num_people;
                candies = candies - i - time * num_people;
            } else {
                res[i - 1] = res[i - 1] + candies;
                candies = 0;
            }
            i++;
        }
        return res;
    }



}