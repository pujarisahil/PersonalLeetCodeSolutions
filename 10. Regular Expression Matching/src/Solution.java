/**
 * Created by sahilpujari on 10/26/16.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        char[] S = s.toCharArray();
        char[] P = p.toCharArray();

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(P[j - 1] == '.' || P[j - 1] == S[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(P[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if(P[j - 2] == '.' || P[j - 2] == S[i - 1]) {
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", ".*"));
    }
}


