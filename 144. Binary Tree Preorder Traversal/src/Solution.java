/**
 * Created by sahilpujari on 2/22/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        preOrderTraversal(root, resultList);

        return resultList;
    }

    public void preOrderTraversal(TreeNode root, List<Integer> resultList) {
        if (root == null) return;

        resultList.add(root.val);
        preOrderTraversal(root.left, resultList);

        preOrderTraversal(root.right, resultList);
    }
}