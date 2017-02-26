/**
 * Created by sahilpujari on 2/25/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

public class Solution {
    public int[] findPermutation(String s) {
        int[] result = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) result[i] = i + 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                int temp = i;
                while (i < s.length() && s.charAt(i) == 'D') i++;
                reverse(result, temp, i);
            }
        }

        return result;
    }

    void reverse(int[] arr, int l, int h) {
        while (l < h) {
            arr[l] ^= arr[h];
            arr[h] ^= arr[l];
            arr[l] ^= arr[h];
            l++;
            h--;
        }
    }
}