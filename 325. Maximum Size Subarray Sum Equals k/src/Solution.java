import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    int maxSubArrayLen(int[] nums, int k) {
        int max = 0;
        int[] copy = nums;
        int withStart = 0;
        int withEnd = 0;
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        Map<Integer, Integer> myMap = new HashMap<>();
        myMap.put(0, -1);

        for(int i = 0; i < nums.length; i++) {
            if(myMap.containsKey(nums[i] - k)) {
                if(max < (i - myMap.get(nums[i] - k))) {
                    withStart = myMap.get(nums[i] - k);
                    withEnd = i;
                    withStart = withStart == -1 ? 0 : withStart;
                }
                max = Math.max(max, i - myMap.get(nums[i] - k));

            }

            if(!myMap.containsKey(nums[i])) {
                myMap.put(nums[i], i);
            }
        }

        for(int i = withStart; i <= withEnd; i++)
            System.out.print(copy[i] + " ");
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3));
    }
}