/**
 * Created by sahilpujari on 3/7/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return max;
    }
}