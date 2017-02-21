import java.util.Arrays;
import java.util.Stack;

/**
 * Created by sahilpujari on 10/30/16.
 */
public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.equals("") || path.equals("/"))
            return path;

        Stack<String> myStack = new Stack<>();
        String[] tokens = path.split("/");
        System.out.println(Arrays.toString(tokens));
        for(String s : tokens) {
            if(s.equals("")) continue;
            if(s.equals("."))
                continue;
            if(!s.equals("..")) {
                myStack.push(s);
            } else {
                if(myStack.isEmpty())
                    continue;
                else {
                    System.out.println("Before " + myStack.toString());
                    myStack.pop();
                    System.out.println("After " + myStack.toString());
                }
            }
        }

        if(myStack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        String[] elements = new String[myStack.size()];
        while(!myStack.isEmpty()) {
            elements[myStack.size() - 1] = myStack.pop();
            // sb.append("/").append(myStack.pop());
        }

        for(String str : elements) {
            sb.append("/").append(str);
        }

        return sb.toString();
    }
}