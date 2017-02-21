import java.util.*;

/**
 * Created by sahilpujari on 10/18/16.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> myMap = new HashMap<>();
        int key = 0;
        for(int i = 0; i < nums.length; i++) myMap.put(nums[i], i);

        for(int i = 0; i < nums.length - 2; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 1; j++) {
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                key = 0 - nums[i] - nums[j];
                if(myMap.containsKey(key) && myMap.get(key) > j) {
                    result.add(Arrays.asList(nums[i], nums[j], key));
                }
            }
        }
        return result;
    }
}