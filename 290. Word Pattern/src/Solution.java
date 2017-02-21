/**
 * Created by sahilpujari on 12/2/16.
 */

import java.util.*;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null) return false;
        if(pattern == null || pattern.equals("") && (str != null && !str.equals("")))
            return false;
        if(pattern == null || str.equals("") && (pattern != null && !pattern.equals("")))
            return false;

        Map<Character, String> map =  new HashMap<>();
        Set<String> usedString = new HashSet<>();
        String[] tokens = str.split(" ");
        if(pattern.length() != tokens.length) return false;

        for(int i = 0; i < tokens.length; i++) {
            if(!map.containsKey(pattern.charAt(i))) {
                if(usedString.contains(tokens[i])) return false;
                map.put(pattern.charAt(i), tokens[i]);
                usedString.add(tokens[i]);
            } else {
                if(!tokens[i].equals(map.get(pattern.charAt(i))))
                    return false;
            }
        }
        return true;
    }
}