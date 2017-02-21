import java.util.HashMap;
import java.util.Map;

/**
 * Created by sahilpujari on 10/28/16.
 */
public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.isEmpty() || t.isEmpty() || s.equals("") || t.equals(""))
            return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        int count = 0;
        String result = "";
        int minLen = s.length();
        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(tMap.containsKey(temp)) {
                if(sMap.containsKey(temp)) {
                    if(sMap.get(temp) < tMap.get(temp))
                        count++;
                    sMap.put(temp, sMap.getOrDefault(temp, 0) + 1);
                } else {
                    sMap.put(temp, sMap.getOrDefault(temp, 0) + 1);
                    count++;
                }
            }

            if(count == t.length()) {
                char sc = s.charAt(left);
                while(!sMap.containsKey(sc) || sMap.get(sc) > tMap.get(sc)) {
                    if(sMap.containsKey(sc) && sMap.get(sc) > tMap.get(sc)) {
                        sMap.put(sc, sMap.get(sc) - 1);
                    }
                    left++;
                    sc = s.charAt(left);
                }

                if(i - left + 1 <= minLen) {
                    result = s.substring(left, i + 1);
                    minLen = i - left + 1;
                }
            }
        }
        return result;
    }
}