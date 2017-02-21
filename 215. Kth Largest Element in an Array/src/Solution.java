/**
 * Created by sahilpujari on 10/30/16.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 1)
            return nums[0];

        return getKthLargest(nums, nums.length - k + 1, 0, nums.length - 1);
    }

    public int getKthLargest(int[] nums, int k, int start, int end) {
        int pivot = nums[end];
        int left = start;
        int right = end;

        while(true) {
            while(nums[left] < pivot && left < right)
                left++;
            while(nums[right] >= pivot && right > left)
                right--;

            if(left == right) break;

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        int temp = nums[left];
        nums[left] = nums[end];
        nums[end] = temp;

        if(k == left + 1) {
            return pivot;
        } else if(k < left + 1) {
            return getKthLargest(nums, k, start, left -1);
        } else {
            return getKthLargest(nums, k, left + 1, end);
        }
    }
}