/**
 * Created by sahilpujari on 2/21/17.
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        combine(resultList, tempList, 1, n, k);

        return resultList;
    }

    public void combine(List<List<Integer>> resultList, List<Integer> tempList, int start, int n, int k) {
        if (k == 0) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i <= n; i++) {
            tempList.add(i);
            combine(resultList, tempList, i + 1, n, k - 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}