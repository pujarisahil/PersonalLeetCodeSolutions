import java.util.HashMap;
import java.util.Map;

/**
 * Created by sahilpujari on 10/30/16.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> freqCount = new HashMap<>();
        for(int x : nums)
            freqCount.put(x, freqCount.getOrDefault(x, 0) + 1);

        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(freqCount.get(nums[i]) <= 2) {
                nums[index++] = nums[i];
            } else {
                freqCount.put(nums[i], freqCount.get(nums[i]) - 1);
            }
        }

        return index;
    }
}