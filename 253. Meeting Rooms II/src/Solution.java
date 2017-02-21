/**
 * Created by sahilpujari on 10/30/16.
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length < 1)
            return 0;

        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);

        PriorityQueue<Interval> myQueue = new PriorityQueue<>(intervals.length, (i1, i2) -> i1.end - i2.end);

        myQueue.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            Interval curr = myQueue.remove();

            if(intervals[i].start >= curr.end) {
                curr.end = intervals[i].end;
            } else {
                myQueue.add(intervals[i]);
            }

            myQueue.add(curr);
        }

        return myQueue.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Interval i1 = new Interval(0, 30);
        Interval i2 = new Interval(5, 10);
        Interval i3 = new Interval(15, 20);

        solution.minMeetingRooms(new Interval[]{i1, i2, i3});
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
