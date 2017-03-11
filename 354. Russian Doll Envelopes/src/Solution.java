/**
 * Created by sahilpujari on 3/10/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[envelopes.length];

        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                int i_w = envelopes[i][0];
                int i_h = envelopes[i][1];

                int j_w = envelopes[j][0];
                int j_h = envelopes[j][1];

                if (i_w > j_w && i_h > j_h) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(dp[i], result);
                }
            }
        }

        return result;
    }
}