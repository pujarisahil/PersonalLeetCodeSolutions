/**
 * Created by sahilpujari on 10/24/16.
 */
public class Solution {
    public int mySqrt(int x) {

        if(x == 0)
            return 0;

        if(x == 1 || x == 2)
            return 1;

        double mid = x / 2.0 + 1; //25
        double remainder = 0;
        while(mid != remainder) { //
            remainder = x / mid; //2, 4, 8
            if(mid <= remainder || Math.abs(mid - remainder) <= 1) {
                break;
            }
            mid /= 2; //12, 6
            if(mid == 0) return 1;
        }

        double p1 = mid;
        double divider = p1;

        while((x - (divider * divider)) > 0.00000001) {
            double temp = x / divider;
            divider = (temp + divider) / 2;
        }
        return (int)divider;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(8192));
    }
}