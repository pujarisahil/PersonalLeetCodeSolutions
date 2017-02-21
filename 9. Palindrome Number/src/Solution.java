/**
 * Created by sahilpujari on 10/14/16.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 10 && x > -1)
            return true;
        if(x < -10 && x <= 0)
            return true;

        int cX = Integer.valueOf(x);

        while(cX / 10 > 0) {

            int temp = cX % 10;
            int mul = 1;
            int curr = cX;
            while(cX > 9) {
                cX /= 10;
                mul *= 10;
            }

            int temp2 = cX % 10;
            cX = curr;
            int sub = mul * temp2;

            if(temp != temp2)
                return false;
            cX = cX - sub;
            cX /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(1000021));
    }
}