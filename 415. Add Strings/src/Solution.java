/**
 * Created by sahilpujari on 2/27/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

public class Solution {
    public String addStrings(String num1, String num2) {
        int len = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (len < num1.length() || len < num2.length()) {
            int num = 0;
            if (len < num1.length()) {
                num += num1.charAt(num1.length() - len - 1) - '0';
            }

            if (len < num2.length()) {
                num += num2.charAt(num2.length() - len - 1) - '0';
            }

            num += carry;
            carry = num / 10;
            sb.append(num % 10);


            len++;
        }

        if (carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }
}