import java.util.HashSet;
import java.util.Set;

/**
 * Created by sahilpujari on 11/21/16.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {

        if(nums == null || nums.length <= 1)
            return false;

        Set<Integer> mySet = new HashSet<>();
        for(int num : nums) {
            if(!mySet.add(num))
                return true;
        }
        return false;
    }
}