/**
 * Created by sahilpujari on 10/28/16.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        int[] dp = new int[n1.length() + n2.length()];
        for(int i = 0; i < n1.length(); i++) {
            for(int j = 0; j < n2.length(); j++) {
                dp[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < dp.length; i++) {
            int mod = dp[i] % 10;
            int carry = dp[i ] / 10;
            if(i + 1< dp.length) {
                dp[i + 1] += carry;
            }
            sb.insert(0, mod);
        }

        while(sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}