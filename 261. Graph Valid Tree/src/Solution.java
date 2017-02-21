import java.util.Arrays;

/**
 * Created by sahilpujari on 10/30/16.
 */
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] temp = new int[n];
        Arrays.fill(temp, -1);

        for(int i = 0; i < edges.length; i++) {
            int x = find(temp, edges[i][0]);
            int y = find(temp, edges[i][1]);

            if(x == y)
                return false;
            temp[x] = y;
        }

        return edges.length == n - 1;
    }

    public int find(int[] nums, int i) {
        if(nums[i] == -1)
            return i;
        return find(nums, nums[i]);
    }
}