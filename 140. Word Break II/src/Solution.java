/**
 * Created by sahilpujari on 3/5/17.
 *
 * @author: Sahil Pujari (pujari@purdue.edu)
 */

import java.util.*;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        return dfs(words, s, new HashMap<>());
    }

    public List<String> dfs(Set<String> wordDict, String s, Map<String, List<String>> myMap) {
        if (myMap.containsKey(s))
            return myMap.get(s);

        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = dfs(wordDict, s.substring(word.length()), myMap);
                for (String t : subList) {
                    res.add(word + (t.isEmpty() ? "" : " ") + t);
                }
            }
        }

        myMap.put(s, res);
        return res;
    }

}