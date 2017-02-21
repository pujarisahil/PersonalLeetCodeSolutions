import java.util.*;

/**
 * Created by sahilpujari on 12/2/16.
 */
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> myList = new ArrayList<>();
        if(strings == null || strings.length == 0) return myList;
        Map<String, List<String>> myMap = new HashMap<>();
        for(String s: strings) {
            String shift = calcShift(s);
            if(!myMap.containsKey(shift)) {
                myMap.put(shift, new ArrayList<>());
            }
            myMap.get(shift).add(s);
        }

        for(String s : myMap.keySet()) {
            List<String> curr = myMap.get(s);
            Collections.sort(curr);
            myList.add(curr);
        }

        return myList;
    }

    public String calcShift(String s) {
        String t = "";
        int l = s.length();
        for(int i = 1; i < l; i++) {
            int diff = s.charAt(i) - s.charAt(i - 1);
            if(diff < 0)
                diff += 26;
            t += "" + ('a' + diff) + ",";
        }
        return t;
    }
}