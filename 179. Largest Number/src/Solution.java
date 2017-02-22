/**
 * Created by sahilpujari on 2/21/17.
 */

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        String[] tempArr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            tempArr[i] = String.valueOf(nums[i]);
        }

        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);
            }
        };

        Arrays.sort(tempArr, myComp);

        if (tempArr[0].charAt(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();

        for (String s : tempArr) sb.append(s);

        return sb.toString();
    }
}