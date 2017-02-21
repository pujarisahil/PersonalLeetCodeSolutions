/**
 * Created by sahilpujari on 10/20/16.
 */
public class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length <= 1)
            return 0;

        int result = 0, min = prices[0];
        for(int i = 0 ; i < prices.length; i++) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return result;
    }
}