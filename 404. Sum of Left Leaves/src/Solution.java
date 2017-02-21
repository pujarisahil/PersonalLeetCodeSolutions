/**
 * Created by sahilpujari on 10/25/16.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        return 0 + helper(root, 0);
    }

    public int helper(TreeNode root, int flag) {
        if(root == null)
            return 0;

        int sum = 0;

        if(flag  == 1) {
            if(root.left == null && root.right == null)
                sum = root.val;
        }
        return sum + helper(root.left, 1) + helper(root.right, 0);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}