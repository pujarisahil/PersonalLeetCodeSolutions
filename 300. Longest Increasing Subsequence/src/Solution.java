/**
 * Created by sahilpujari on 3/10/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int result = 1;

        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(dp[i], result);
                }
            }
        }

        return result;
    }
}