/**
 * Created by sahilpujari on 3/5/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

public class Solution {
    public int maxCoins(int[] nums) {
        int[] numsTwo = new int[nums.length + 2];
        int n = 1;
        for (int a : nums)
            if (a > 0)
                numsTwo[n++] = a;

        numsTwo[0] = 1;
        numsTwo[n++] = 1;

        int[][] memo = new int[n][n];

        return maxCoins(numsTwo, memo, 0, n - 1);
    }

    public int maxCoins(int[] nums, int[][] memo, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];

        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            ans = Math.max(ans, nums[left] * nums[i] * nums[right] +
                    maxCoins(nums, memo, left, i) +
                    maxCoins(nums, memo, i, right)
            );
        }

        memo[left][right] = ans;
        return ans;
    }
}