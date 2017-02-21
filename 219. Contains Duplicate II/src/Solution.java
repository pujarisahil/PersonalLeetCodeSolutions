import java.util.HashMap;
import java.util.Map;

/**
 * Created by sahilpujari on 11/21/16.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> myMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(myMap.containsKey(nums[i])) {
                int pre = myMap.get(nums[i]);
                if(i - pre <= k)
                    return true;
            }
            myMap.put(nums[i], i);
        }
        return false;
    }
}