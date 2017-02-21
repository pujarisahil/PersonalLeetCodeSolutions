/**
 * Created by sahilpujari on 10/18/16.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int m = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if (m == -1 || nums[m] != 0) {
                    m = i;
                }
            } else {
                if(m != -1) {
                    int temp = nums[i];
                    nums[i] = nums[m];
                    nums[m] = temp;
                    m++;
                }
            }
        }
    }
}
