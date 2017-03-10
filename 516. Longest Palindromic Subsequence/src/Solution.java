/**
 * Created by sahilpujari on 3/9/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        return longestPalindromeSubseq(s.toCharArray(), 0, s.length() - 1, dp);
    }

    public int longestPalindromeSubseq(char[] s, int i, int j, int[][] dp) {
        if (dp[i][j] != 0)
            return dp[i][j];

        if (i == j) {
            dp[i][j] = 1;
            return 1;
        }

        if (s[i] == s[j] && i + 1 == j) {
            dp[i][j] = 2;
            return 2;
        }

        if (s[i] == s[j]) {
            int temp = longestPalindromeSubseq(s, i + 1, j - 1, dp) + 2;
            dp[i][j] = temp;
            return temp;
        }

        int temp = Math.max(longestPalindromeSubseq(s, i + 1, j, dp), longestPalindromeSubseq(s, i, j - 1, dp));
        dp[i][j] = temp;
        return temp;
    }
}