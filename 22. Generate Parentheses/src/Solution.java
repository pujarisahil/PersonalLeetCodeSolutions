/**
 * Created by sahilpujari on 3/4/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3).toString());
    }

    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();

        formSubsets(resultList, n, "", 0, 0);

        return resultList;
    }

    public void formSubsets(List<String> resultList, int n, String str, int left, int right) {
        if (str.length() == n * 2) {
            resultList.add(str);
            return;
        }

        if (left < n) {
            formSubsets(resultList, n, str + "(", left + 1, right);
        }

        if (right < left) {
            formSubsets(resultList, n, str + ")", left, right + 1);
        }
    }
}