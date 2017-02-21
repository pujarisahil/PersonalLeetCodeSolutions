/**
 * Created by sahilpujari on 10/25/16.
 */
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution {

    public boolean knows(int a, int b) {
        return true;
    }
    public int findCelebrity(int n) {
        int celebrity = 0;

        for(int i = 1; i < n ; i++) {
            if(knows(celebrity, i))
                celebrity = i;
        }

        for(int i = 0; i < n; i++) {
            if((i < celebrity && knows(celebrity, i)) || (!knows(i, celebrity)))
                return -1;
            if(i > celebrity && !knows(i, celebrity))
                return -1;
        }
        return celebrity;
    }
}