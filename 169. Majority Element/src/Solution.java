/**
 * Created by sahilpujari on 2/21/17.
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int expectedFreq = nums.length / 2;
        for (int a : nums) {
            int currentCount = freqMap.getOrDefault(a, 0);
            if (currentCount == expectedFreq) return a;
            freqMap.put(a, ++currentCount);
        }

        return -1;
    }
}