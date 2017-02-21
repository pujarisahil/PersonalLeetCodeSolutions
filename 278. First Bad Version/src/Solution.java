/**
 * Created by sahilpujari on 10/18/16.
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right  = n;

        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(new VersionControl().isBadVesion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if(new VersionControl().isBadVesion(left))
            return left;

        return right;
    }
}