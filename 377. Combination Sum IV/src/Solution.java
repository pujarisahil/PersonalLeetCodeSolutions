import java.util.Arrays;

/**
 * Created by sahilpujari on 10/30/16.
 */
public class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }

        // if(target < 0 || target >= nums.length) return 0;

        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        return helper(nums, target);
    }

    public int helper(int[] nums, int target) {
        if(dp[target] != -1) {
            return dp[target];
        }

        int res = 0;

        for(int i = 0; i < nums.length; i++) {
            if(target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }

        dp[target] = res;
        return res;
    }
}