/**
 * Created by sahilpujari on 2/22/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        TreeNode result = visit(nums, 0, nums.length - 1);

        return result;
    }

    public TreeNode visit(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = visit(nums, low, mid - 1);
        midNode.right = visit(nums, mid + 1, high);
        return midNode;
    }
}