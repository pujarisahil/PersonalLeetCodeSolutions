import java.util.Stack;

/**
 * Created by sahilpujari on 11/18/16.
 */
class Level {
    int lvl;
    int len;
    public Level(int lvl, int len) {
        this.lvl = lvl;
        this.len = len;
    }

    @Override
    public String toString() {
        return "Level: " + lvl + " Length: " + len;
    }
}

public class Solution {
    public int lengthLongestPath(String input) {

        if(input == null || input.length() == 0)
            return 0;

        Stack<Level> myStack = new Stack<>();
        String[] tokens = input.split("\n");
        int max = 0;
        for(String tok : tokens) {
            int level = tok.length() - tok.replace("\t", "").length();

            while(!myStack.isEmpty() && level <= myStack.peek().lvl)
                myStack.pop();

            if(tok.contains(".")) {
                if(myStack.isEmpty()) {
                    max = Math.max(max, tok.replace("\t", "").length());
                } else {
                    max = Math.max(max, myStack.peek().len + tok.replace("\t", "").length());
                }
            }

            if(myStack.isEmpty()) {
                myStack.push(new Level(level, tok.replace("\t", "").length() + 1));
            } else {
                myStack.push(new Level(level, myStack.peek().len + tok.replace("\t", "").length() + 1));
            }

            System.out.println("Stack now is " + myStack.toString());
        }


        return max;
    }
}