import java.util.ArrayList;
import java.util.List;

/**
 * Created by sahilpujari on 12/2/16.
 */
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(n <= 3) {
            return result;
        }

        getFactorsHelper(n, 2, new ArrayList<Integer>(), result);
        return result;
    }

    public void getFactorsHelper(int n, int start, List<Integer> curr, List<List<Integer>> result) {
        if(n == 1) {
            if(curr.size() > 1) result.add(new ArrayList<Integer>(curr));
            return;
        }

        for(int i = start; i <= (int) Math.sqrt(n); i++) {
            if(n % i != 0) continue;
            curr.add(i);
            getFactorsHelper(n / i, i, curr, result);
            curr.remove(curr.size() - 1);
        }

        int i = n;
        curr.add(i);
        getFactorsHelper(n / i, i, curr, result);
        curr.remove(curr.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getFactors(12);
    }
}