/**
 * Created by sahilpujari on 3/10/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int change(int amount, int[] coins) {
        Map<Integer, Map<Integer, Integer>> waysMap = new HashMap<>();
        return makeChange(amount, coins, waysMap, 0);
    }

    public int makeChange(int amount, int[] coins, Map<Integer, Map<Integer, Integer>> waysMap, int index) {
        if (amount == 0)
            return 1;

        if (index >= coins.length)
            return 0;

        boolean exists = false;
        if (waysMap.containsKey(amount)) {
            exists = true;
            Map<Integer, Integer> tempMap = waysMap.get(amount);
            if (tempMap.containsKey(index))
                return tempMap.get(index);
        }

        int amountWeHave = 0;
        int ways = 0;

        while (amountWeHave <= amount) {
            int remainingAmount = amount - amountWeHave;
            ways += makeChange(remainingAmount, coins, waysMap, index + 1);
            amountWeHave += coins[index];
        }

        if (exists) {
            waysMap.get(amount).put(index, ways);
        } else {
            waysMap.put(amount, new HashMap<>());
            waysMap.get(amount).put(index, ways);
        }
        return ways;
    }
}