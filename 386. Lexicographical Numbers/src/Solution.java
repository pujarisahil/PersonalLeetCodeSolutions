/**
 * Created by sahilpujari on 2/25/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, result);
        }

        return result;
    }

    public void dfs(int num, int n, List<Integer> list) {
        if (num > n) return;

        list.add(num);
        for (int i = 0; i < 10; i++) {
            if (10 * num + i > n) return;
            dfs(10 * num + i, n, list);
        }
    }
}