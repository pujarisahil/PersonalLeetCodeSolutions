/**
 * Created by sahilpujari on 10/28/16.
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);

        return result.toString();
    }

    public void helper(TreeNode root, List<Integer> result) {
        if(root == null) {
            result.add(Integer.MIN_VALUE);
            return;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;

        data = data.substring(1, data.length() - 1);
        String[] tokens = data.split(",");

        int[] myArr = new int[tokens.length];
        for(int i = 0; i < tokens.length; i++) myArr[i] = Integer.parseInt(tokens[i].trim());

        TreeNode result = help2(myArr);
        return result;
    }

    int index = 0;
    public TreeNode help2(int[] myArr) {
        if(index == myArr.length || myArr[index] == Integer.MIN_VALUE) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(myArr[index]);
        index++;

        root.left = help2(myArr);
        root.right = help2(myArr);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));