/**
 * Created by sahilpujari on 10/14/16.
 */
public class Solution {
    public int myAtoi(String str) {
        str = toConsider(str);
        if(!isNumeric(str))
            return 0;

        int sum = 0;
        int mul = 1;
        int prev = 0;
        boolean isNegative = false;
        if(str.charAt(0) == '-')
            isNegative = true;
        for(int i = str.length() - 1; i >= 0; i--) {
            if(str.charAt(i) == '-')
                isNegative = true;
            else if (isNumeric("" + str.charAt(i))) {
                int temp = (str.charAt(i) - '0') * mul;
                sum += temp;
                if(mul < prev || (mul > 1 && mul % 10 != 0))
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                mul *= 10;
                prev = mul;
            }
        }
        if(isNegative) sum *= -1;
        if(!isNegative && sum < 0)
            return Integer.MAX_VALUE;
        else if(isNegative && sum > 0)
            return Integer.MIN_VALUE;
        return sum;
    }

    public String toConsider(String str) {
        String temp = "";
        int numChars = 0;
        int numSym = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9')
                numChars++;
            if(str.charAt(i) == '+' || str.charAt(i) == '-')
                numSym++;
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                break;
            else if(str.charAt(i) == ' ' && (numChars > 0 || numSym > 0))
                break;
            else
                temp += "" + str.charAt(i);
        }
        return temp.trim();
    }

    public boolean isNumeric(String str) {
        int count = 0;
        int numberOfPeriods = 0;
        int numberOfNums = 0;
        int numberOfSymbols = 0;
        while(count != str.length()) {
            char currentChar = str.charAt(count++);
            if (currentChar >= '0' && currentChar <= '9') {
                numberOfNums++;
            } else if(currentChar == '-' || currentChar == '+') {
                numberOfSymbols++;
            } else if(currentChar == '.') {
                numberOfPeriods++;
            } else if(currentChar == ' ') {
                continue;
            }else {
                return false;
            }
        }
        return numberOfSymbols < 2 && numberOfPeriods < 2 && numberOfNums > 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("      -11919730356x"));
    }
}
