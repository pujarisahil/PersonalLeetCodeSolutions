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
    public int sumNumbers(TreeNode root) {
        return visit(root, 0);
    }

    public int visit(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.right == null && root.left == null)
            return sum * 10 + root.val;
        return visit(root.left, sum * 10 + root.val) + visit(root.right, sum * 10 + root.val);
    }
}
