/**
 * Created by sahilpujari on 3/11/17.
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invertTreeHelper(root);

        return root;
    }

    public void invertTreeHelper(TreeNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }
}