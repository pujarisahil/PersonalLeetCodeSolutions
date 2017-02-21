/**
 * Created by sahilpujari on 10/25/16.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> myList = new ArrayList<>();
        if(intervals == null || intervals.size() < 1) {
            return myList;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        Interval last = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if(curr.start <= last.end) {
                last.end = Math.max(curr.end, last.end);
            } else {
                myList.add(last);
                last = curr;
            }
        }
        myList.add(last);
        return myList;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}