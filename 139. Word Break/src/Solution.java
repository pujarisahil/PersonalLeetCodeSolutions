import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sahilpujari on 10/20/16.
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        if(s.length() < 2)
            return wordDict.contains(s);

        dp[0] = true;
        int l = s.length();

        for(int i = 1; i <= l ; i ++) {

            if(!dp[i] && wordDict.contains(s.substring(0, i)))
                dp[i] = true;

            if(dp[i]) {
                if(i == l)
                    return true;

                for (int j = i + 1; j <= l; j++) {
                    if(!dp[j]) {
                        if(wordDict.contains(s.substring(i, j))) {
                            dp[j] = true;
                        }
                    }

                    if(dp[j] && j == l)
                        return  true;
                }
            }
        }
        return false;
    }
}