/**
 * Created by sahilpujari on 2/25/17.
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Map<Integer, List<Integer>> myMap = new LinkedHashMap<>();
        visit(root, myMap, 0);
        int i = 1;
        for (Integer a : myMap.keySet()) {
            List<Integer> list = myMap.get(a);
            if (i % 2 == 0)
                Collections.reverse(list);
            resultList.add(list);
            i++;
        }

        return resultList;
    }

    public void visit(TreeNode root, Map<Integer, List<Integer>> myMap, int level) {
        if (root == null) return;

        if (!myMap.containsKey(level))
            myMap.put(level, new ArrayList<>());
        myMap.get(level).add(root.val);

        visit(root.left, myMap, level + 1);
        visit(root.right, myMap, level + 1);
    }
}