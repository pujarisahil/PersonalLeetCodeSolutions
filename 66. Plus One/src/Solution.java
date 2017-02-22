/**
 * Created by sahilpujari on 2/21/17.
 */

import java.util.Stack;

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        Stack<Integer> resultStack = new Stack<>();
        int index = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + carry;
            if (index == 0)
                num = digits[i] + carry + 1;
            carry = num / 10;
            int toPut = num % 10;

            resultStack.push(toPut);
            index++;
        }

        if (carry != 0) resultStack.push(carry);

        int[] result = new int[resultStack.size()];
        index = 0;
        while (!resultStack.isEmpty())
            result[index++] = resultStack.pop();

        return result;
    }
}