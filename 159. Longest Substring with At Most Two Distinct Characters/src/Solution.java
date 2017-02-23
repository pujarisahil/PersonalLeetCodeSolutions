/**
 * Created by sahilpujari on 2/22/17.
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int max = 0;
        int high = 0, low = 0;

        while (high < s.length()) {
            if (freqMap.size() <= 2) {
                char c = s.charAt(high);
                freqMap.put(c, high);
                high++;
            }

            if (freqMap.size() > 2) {
                int leftMost = s.length();
                for (char c : freqMap.keySet())
                    leftMost = Math.min(freqMap.get(c), leftMost);
                char c = s.charAt(leftMost);
                freqMap.remove(c);
                low = leftMost + 1;
            }

            max = Math.max(max, high - low);
        }
        return max;
    }
}