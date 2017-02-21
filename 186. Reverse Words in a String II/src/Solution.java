import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by sahilpujari on 11/1/16.
 */
public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0)
            return;
        int j = s.length - 1;
        for(int i = 0; i < j; i++) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }

        int start = 0, end = 1;
        for(int i = 0; i < s.length; i++) {
            char curr = s[i];
            if(i == s.length - 1) {
                end = s.length - 1;
                for(int x = start; x < end; x++) {
                    char temp = s[x];
                    s[x] = s[end];
                    s[end] = temp;
                    end--;
                }
            } else if(curr == ' ') {
                end = i - 1;
                for(int x = start; x < end; x++) {
                    char temp = s[x];
                    s[x] = s[end];
                    s[end] = temp;
                    end--;
                }
                start = i + 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution =  new Solution();
        char[] test = "hello world how are you".toCharArray();
        solution.reverseWords(test);
    }

}

