/**
 * Created by sahilpujari on 2/27/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

public class Solution {
    public String getHint(String secret, String guess) {
        int[] nums = new int[10];

        int bull = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bull++;
            else {
                if (nums[secret.charAt(i) - '0']++ < 0) cows++;
                if (nums[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }

        return bull + "A" + cows + "B";
    }
}