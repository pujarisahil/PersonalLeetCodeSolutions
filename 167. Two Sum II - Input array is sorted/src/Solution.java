/**
 * Created by sahilpujari on 10/14/16.
 */
import java.util.*;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while(i < j) {
            int temp  = numbers[i] + numbers[j];
            if(temp < target) {
                i++;
            } else if(temp > target) {
                j--;
            } else {
                result[0] = ++i;
                result[1] = ++j;
                return result;
            }
        }
        return result;
    }
}