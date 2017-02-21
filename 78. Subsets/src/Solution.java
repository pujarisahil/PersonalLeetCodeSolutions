import java.util.ArrayList;
import java.util.List;

/**
 * Created by sahilpujari on 10/25/16.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null)
            return result;
        List<Integer> myList = new ArrayList<>();
        helper(nums, 0, myList, result);
        return result;
    }

    public void helper(int[] nums, int index, List<Integer> myList, List<List<Integer>> result) {
        result.add(new ArrayList<>(myList));

        for(int i = index; i < nums.length; i++) {
            myList.add(nums[i]);
            helper(nums, i + 1, myList, result);
            myList.remove(myList.size() - 1);
        }
    }
}