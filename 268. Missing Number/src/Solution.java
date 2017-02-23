/**
 * Created by sahilpujari on 2/22/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

public class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}