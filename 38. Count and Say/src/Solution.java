import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sahilpujari on 10/24/16.
 */
public class Solution {
    public String countAndSay(int n) {
        String result = "";
        Stack<Integer> myQueue = new Stack<>();

        while (n > 9) {
            myQueue.push(n % 10);
            n /= 10;
        }
        myQueue.push(n);
        int prev = 0;
        int count = 1;
        prev = myQueue.pop();
        while (!myQueue.isEmpty()) {
            int temp = myQueue.pop();
            if (prev == temp) {
                count++;
            } else {
                result += "" + count + prev;
                count = 1;
            }
            prev = temp;
        }
        result += "" + count + prev;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(2223344));
    }
}