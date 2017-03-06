/**
 * Created by sahilpujari on 3/5/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> resultMap = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (resultMap.containsKey(amount))
            return resultMap.get(amount);
        int n = amount + 1;

        for (int coin : coins) {
            int temp = 0;

            if (amount >= coin) {
                int next = coinChange(coins, amount - coin);
                resultMap.put(amount - coin, next);
                if (next >= 0)
                    temp = 1 + next;
            }

            if (temp > 0)
                n = Math.min(temp, n);
        }

        int result = (n == amount + 1) ? -1 : n;
        return result;
    }
}