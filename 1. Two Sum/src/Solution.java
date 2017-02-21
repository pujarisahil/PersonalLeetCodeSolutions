/**
 * Created by sahilpujari on 10/13/16.
 */
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(myMap.containsKey(nums[i])) {
                result[0] = myMap.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                myMap.put(target - nums[i], i);
            }
        }
        return result;
    }
}
