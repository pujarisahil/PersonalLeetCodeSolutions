/**
 * Created by sahilpujari on 2/9/17.
 */

import java.util.*;

public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        return (x + y + z == 0) || z <= x+y && z % gcd(x, y) == 0;
    }

    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x%y);
    }
}