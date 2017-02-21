import java.util.*;

/**
 * Created by sahilpujari on 10/30/16.
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;
        Arrays.sort(nums);
        List<Integer> solution = new ArrayList<>();
        Set<List<Integer>> mySet = new HashSet<>();
        helper(nums, solution, result, 0, mySet);

        return result;
    }

    public void helper(int[] nums, List<Integer> solution, List<List<Integer>> result, int index, Set<List<Integer>> mySet) {
        if(!mySet.contains(new ArrayList<>(solution))) {
            result.add(new ArrayList<>(solution));
            mySet.add(new ArrayList<>(solution));
        }


        for(int i = index; i < nums.length; i++) {
            solution.add(nums[i]);
            helper(nums, solution, result, i + 1, mySet);
            solution.remove(solution.size() - 1);
        }
    }
}