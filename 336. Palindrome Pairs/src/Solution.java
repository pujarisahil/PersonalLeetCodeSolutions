/**
 * Created by sahilpujari on 2/25/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> solution = new ArrayList<>();
        Map<String, Integer> myMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) myMap.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);

                if (isPalindrome(str1)) {
                    String str2Reverse = new StringBuilder(str2).reverse().toString();
                    if (myMap.containsKey(str2Reverse) && myMap.get(str2Reverse) != i) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(myMap.get(str2Reverse));
                        tempList.add(i);
                        solution.add(tempList);
                    }
                }

                if (isPalindrome(str2)) {
                    String str1Reverse = new StringBuilder(str1).reverse().toString();
                    if (myMap.containsKey(str1Reverse) && myMap.get(str1Reverse) != i && str2.length() != 0) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(i);
                        tempList.add(myMap.get(str1Reverse));
                        solution.add(tempList);
                    }
                }
            }
        }

        return solution;
    }

    public boolean isPalindrome(String str) {
        int n = str.length();

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1))
                return false;
        }

        return true;
    }
}