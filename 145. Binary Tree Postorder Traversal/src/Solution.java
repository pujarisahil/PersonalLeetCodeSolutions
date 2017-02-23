/**
 * Created by sahilpujari on 2/22/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> myStack = new Stack<>();
        TreeNode p = root;
        while (!myStack.isEmpty() || p != null) {
            if (p != null) {
                myStack.push(p);
                result.add(0, p.val);
                p = p.right;
            } else {
                p = myStack.pop();
                p = p.left;
            }
        }

        return result;
    }
}