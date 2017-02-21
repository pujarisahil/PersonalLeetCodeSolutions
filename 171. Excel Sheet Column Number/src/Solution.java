/**
 * Created by sahilpujari on 11/1/16.
 */
public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) return 0;
        int result = 0;
        int mul = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            result += (int)Math.pow(26, mul++) * (s.charAt(i) - 'A' + 1);
        }

        return result;
    }
}