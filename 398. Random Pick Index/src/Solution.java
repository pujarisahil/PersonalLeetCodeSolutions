import java.util.*;

/**
 * Created by sahilpujari on 10/30/16.
 */
public class Solution {

    int[] nums;
    Map<Integer, List<Integer>> myMap;
    public Solution(int[] nums) {
        this.nums = nums;
        myMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(myMap.containsKey(nums[i])) {
                myMap.get(nums[i]).add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                myMap.put(nums[i], temp);
            }
        }
    }

    public int pick(int target) {
        List<Integer> myList = myMap.get(target);
        Random rand = new Random();
        return myList.get(rand.nextInt(myList.size()));

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */