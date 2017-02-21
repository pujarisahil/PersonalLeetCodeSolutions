/**
 * Created by sahilpujari on 10/23/16.
 */
import java.util.ArrayList;
import java.util.List;

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
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> binaryTreePaths(TreeNode root) {

        if(root == null) return result;

        TreeNode temp = root;

        if(temp.left == null && temp.right == null) {
            sb.append(temp.val);
            result.add(sb.toString());
            sb = new StringBuilder();
        }

        if(temp.left != null) {
            sb.append(temp.val);
            sb.append("->");
            binaryTreePaths(temp.left);
            sb = new StringBuilder();
        }

        if(temp.right != null) {
            sb.append(temp.val);
            sb.append("->");
            binaryTreePaths(temp.right);
            sb = new StringBuilder();
        }

        return result;
    }
}