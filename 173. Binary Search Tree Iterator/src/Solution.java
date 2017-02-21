/**
 * Created by sahilpujari on 10/28/16.
 */

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    Stack<TreeNode> myTree;
    public Solution(TreeNode root) {
        myTree = new Stack<>();
        while(root != null) {
            myTree.push(root);
            root = root.left;
        }
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !myTree.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = myTree.pop();
        int result = temp.val;
        if(temp.right != null) {
            temp = temp.right;
            while(temp != null ) {
                myTree.add(temp);
                temp = temp.left;
            }
        }
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */