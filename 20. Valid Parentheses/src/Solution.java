import java.util.Stack;

/**
 * Created by sahilpujari on 10/23/16.
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '{' || c == '[' || c == '(')
                stack.push(c);
            else {
                if(stack.isEmpty())
                    return false;
                if(stack.peek() == '(' && c != ')')
                    return false;
                if(stack.peek() == '[' && c != ']')
                    return false;
                if(stack.peek() == '{' && c != '}')
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
    }
}