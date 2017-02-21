/**
 * Created by sahilpujari on 10/28/16.
 */
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int read4(char[] buf) {
        return 1;
    }
    public int read(char[] buf, int n) {
        if(n <= 0) {
            return n;
        }
        char[] temp = new char[4];
        int i = 0;
        while(i < n) {
            int read = read4(temp);
            int j = 0;
            while(j < read && i < n) {
                buf[i++] = temp[j++];
            }

            if(read < 4) {
                break;
            }
        }
        return i;
    }
}