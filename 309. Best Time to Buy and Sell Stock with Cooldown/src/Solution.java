/**
 * Created by sahilpujari on 3/10/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

public class Solution {
    public int maxProfit(int[] prices) {
        int prevBuy = 0;
        int buy = Integer.MIN_VALUE;
        int prevSell = 0;
        int sell = 0;

        for (int price : prices) {
            prevBuy = buy;
            buy = Math.max(prevSell - price, prevBuy);
            prevSell = sell;
            sell = Math.max(prevBuy + price, prevSell);
        }

        return sell;
    }
}