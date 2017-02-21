/**
 * Created by sahilpujari on 10/13/16.
 */
import java.util.*;

public class Solution {

    public boolean isPalindrome(String s) {
        for(int i = 0; i < s.length() /2; ++i) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        HashMap<String, List<Integer>> myMap = new HashMap<>();
        if(s.length() < 2)
            return s;
        for(int i = 0; i < s.length(); i++) {
            String curr = String.valueOf(s.charAt(i));
            if(myMap.containsKey(curr)) {
                myMap.get(curr).add(i);
            } else {
                List<Integer> myList = new ArrayList<>();
                myList.add(i);
                myMap.put(curr, myList);
            }
        }

        String biggest = "";
        int biggestLength = 0;
        for(String key : myMap.keySet()) {
            List<String> words = new ArrayList<>();
            String curr = key;
            for(int j = 0; j < myMap.get(curr).size() - 1; j++) {
                for(int z = j + 1; z < myMap.get(curr).size(); z++)
                    words.add(s.substring(myMap.get(curr).get(j), myMap.get(curr).get(z) + 1));
            }

            for(String str : words) {
                if(isPalindrome(str)) {
                    if(str.length() > biggestLength) {
                        biggest = str;
                        biggestLength = str.length();
                    }
                }
            }
        }
        return biggest;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.print(sol.longestPalindrome("ababccb"));
    }
}
