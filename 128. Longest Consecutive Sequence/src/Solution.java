import java.util.HashSet;
import java.util.Set;

/**
 * Created by sahilpujari on 10/30/16.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;

        Set<Integer> mySet = new HashSet<>();
        for(int n : nums)
            mySet.add(n);

        for(int i = 0; i < nums.length; i++) {
            int left = nums[i] - 1;
            int right = nums[i] + 1;
            int count = 1;

            while(mySet.contains(left)) {
                count++;
                mySet.remove(left);
                left--;
            }

            while(mySet.contains(right)) {
                count++;
                mySet.remove(right);
                right++;
            }

            max = Math.max(count, max);
        }

        return max;
    }
}