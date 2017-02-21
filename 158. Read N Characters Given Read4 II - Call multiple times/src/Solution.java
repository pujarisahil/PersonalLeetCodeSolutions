/**
 * Created by sahilpujari on 10/25/16.
 */
/* The read4 API is defined in the parent class Reader4.
       */

public class Solution {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int i4 = 0, n4 = 0;
    char[] buf4 = new char[4];

    int read4(char[] buf) {
        return 4;
    }
    public int read(char[] buf, int n) {


        int i = 0;
        while(i < n) {
            if(n4 == i4) {
                i4 = 0;
                n4 = read4(buf4);
                if(n4 == 0)
                    break;
            }
            buf[i++] = buf4[i4++];
        }
        return i;
    }
}