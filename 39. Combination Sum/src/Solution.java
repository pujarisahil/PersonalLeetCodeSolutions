import java.util.*;

/**
 * Created by sahilpujari on 10/30/16.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return result;
        Arrays.sort(candidates);

        List<Integer> solution = new ArrayList<>();
        helper(result, solution, 0, target, candidates);
        return result;

    }

    public void helper(List<List<Integer>> result, List<Integer> solution, int index, int target, int[] candidates) {
        if(target == 0) {
            result.add(new ArrayList<>(solution));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if(candidates[i] > target) {
                return;
            }
            solution.add(candidates[i]);
            helper(result, solution, i, target - candidates[i], candidates);
            solution.remove(solution.size() - 1);
        }
    }
}