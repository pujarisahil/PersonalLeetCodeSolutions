/**
 * Created by sahilpujari on 10/13/16.
 */
import java.util.*;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        Map<String, Integer> myMap = new HashMap<>();
        int biggestLength = 0;
        for(int i = 0, z = 0; i < s.length(); i++) {
            String curr = String.valueOf(s.charAt(i));
            if(myMap.containsKey(curr)) {
                z = Math.max(myMap.get(curr), z);
            }
            biggestLength = Math.max(biggestLength, i - z + 1);
            myMap.put(curr, i + 1);
        }
        return biggestLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}