/**
 * Created by sahilpujari on 3/4/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> resultList = new ArrayList<>();
        backTrack(resultList, s, new ArrayList<>());
        return resultList;
    }

    public void backTrack(List<List<String>> resultList, String s, List<String> tempList) {
        if (0 == s.length()) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int j = 0; j < s.length(); j++) {
            if (isPalindrome(s.substring(0, j + 1))) {
                tempList.add(s.substring(0, j + 1));
                backTrack(resultList, s.substring(j + 1), tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) return false;
        }
        return true;
    }
}