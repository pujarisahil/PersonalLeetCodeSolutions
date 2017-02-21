/**
 * Created by sahilpujari on 10/18/16.
 */
public class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length() - 1, bLen = b.length() - 1;
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        while(aLen >= 0 || bLen >= 0) {
            int aTemp = 0;
            int bTemp = 0;

            if(aLen >= 0) {
                aTemp = a.charAt(aLen--) == '0' ? 0 : 1;
            }

            if(bLen >= 0) {
                bTemp = b.charAt(bLen--) == '0' ? 0 : 1;
            }

            int sum = aTemp + bTemp + flag;

            if(sum >= 2) {
                sb.append(sum - 2);
                flag = 1;
            } else {
                sb.append(sum);
                flag = 0;
            }
        }

        if(flag == 1) sb.append("1");

        return sb.reverse().toString();
    }
}
