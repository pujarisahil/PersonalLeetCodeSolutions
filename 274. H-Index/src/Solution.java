import java.util.Arrays;

/**
 * Created by sahilpujari on 10/30/16.
 */
public class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0) return 0;
        Arrays.sort(citations);
        int N = citations.length;
        int res = 0;
        for(int i=0; i<N; i++){
            if(N-i <= citations[i])
                return N-i;
        }
        return 0;
    }
}