/**
 * Created by sahilpujari on 2/27/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int highestCount = 0;

        Map<Integer, Integer> freqMap = new HashMap<>();

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            freqMap.put(curr.val, freqMap.getOrDefault(curr.val, 0) + 1);
            highestCount = Math.max(highestCount, freqMap.get(curr.val));

            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        List<Integer> resultList = new ArrayList<>();
        for (int a : freqMap.keySet()) {
            if (freqMap.get(a) == highestCount) resultList.add(a);
        }

        int[] result = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++)
            result[i] = resultList.get(i);

        return result;
    }
}