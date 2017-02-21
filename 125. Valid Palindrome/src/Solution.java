/**
 * Created by sahilpujari on 10/21/16.
 */
public class Solution {

    public String cleanString(String str) {
        String result = "";
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
                result += ("" + c).toLowerCase();
            }
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s);
        int n = s.length();
        for(int i = 0; i < n / 2; ++i) {
            if(s.charAt(i) != s.charAt(n - i - 1))
                return false;
        }
        return true;
    }
}