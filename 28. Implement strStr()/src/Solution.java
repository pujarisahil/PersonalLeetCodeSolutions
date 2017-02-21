/**
 * Created by sahilpujari on 10/14/16.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0)
            return 0;

        if(haystack.length() == 0 && needle.length() != 0)
            return -1;

        if(haystack.length() != 0 && needle.length() == 0)
            return 0;

        int start = 0;
        char temp = needle.charAt(0);
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.length() - i < needle.length())
                return -1;
            char curr = haystack.charAt(i);
            if(curr == temp) {
                start = i;
                int len = 0;
                int t = 0;
                for(int j = start; j < needle.length() + start; j++) {
                    if(haystack.charAt(j) != needle.charAt(t++))
                        break;
                    else
                        len++;

                    if(len == needle.length())
                        return start;
                }
            }
        }
        return -1;
    }
}