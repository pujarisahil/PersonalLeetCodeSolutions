/**
 * Created by sahilpujari on 2/21/17.
 */

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Map<Integer, Map<Integer, Integer>> myMap = new HashMap<>();
        visit(root, 0, 0, myMap);
        int highestLevel = Integer.MIN_VALUE;

        for (int a : myMap.keySet()) {
            highestLevel = Math.max(highestLevel, a);
        }

        Map<Integer, Integer> tempMap = myMap.get(highestLevel);
        int lowestOne = Integer.MAX_VALUE;

        for (int a : tempMap.keySet()) {
            lowestOne = Math.min(a, lowestOne);
        }

        return tempMap.get(lowestOne);
    }

    public void visit(TreeNode root, int level, int rightOrLeft, Map<Integer, Map<Integer, Integer>> myMap) {
        if (root == null) return;

        if (!myMap.containsKey(level))
            myMap.put(level, new HashMap<>());
        myMap.get(level).put(rightOrLeft, root.val);

        visit(root.left, level + 1, rightOrLeft - 1, myMap);
        visit(root.right, level + 1, rightOrLeft + 1, myMap);
    }
}