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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        inOrderTraversal(root, resultList);

        return resultList;
    }

    public void inOrderTraversal(TreeNode root, List<Integer> resultList) {
        if (root == null) return;


        inOrderTraversal(root.left, resultList);
        resultList.add(root.val);
        inOrderTraversal(root.right, resultList);
    }
}