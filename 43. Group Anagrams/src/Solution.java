import java.util.*;

public class Solution {
    Map<String, List<String>> myMap = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null) return new ArrayList<List<String>>();

        for(String str : strs) {
            char[] curr2 = str.toCharArray();
            Arrays.sort(curr2);
            String curr = new String(curr2);
            if(myMap.containsKey(curr)) {
                List<String> temp = myMap.get(curr);
                temp.add(str);
                myMap.put(curr, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                myMap.put(curr, temp);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String a : myMap.keySet()) {
            System.out.println(a);
            result.add(myMap.get(a));
        }

        return result;
    }
}