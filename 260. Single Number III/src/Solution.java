/**
 * Created by sahilpujari on 2/22/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff ^= nums[i];
        }

        diff &= -diff;

        int[] result = new int[2];

        for (int n : nums) {
            if ((n & diff) == 0)
                result[0] ^= n;
            else
                result[1] ^= n;
        }
        return result;
    }
}