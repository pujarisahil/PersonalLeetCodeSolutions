/**
 * Created by sahilpujari on 2/9/17.
 */

import java.util.*;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs != null && strs.length != 0) {
            String pre = strs[0];

            for(int i = 1; i < strs.length; i++) {
                while(strs[i].indexOf(pre) != 0)
                    pre = pre.substring(0, pre.length() - 1);
            }

            return pre;
        }

        return "";
    }
}