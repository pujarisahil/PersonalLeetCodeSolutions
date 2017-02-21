import java.util.*;

/**
 * Created by sahilpujari on 11/2/16.
 */
class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> myStack = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    public void push(int x) {
        if(myStack.isEmpty())
            myStack.push(x);
        else {
            while(!myStack.isEmpty())
                temp.push(myStack.pop());

            myStack.push(x);
            while(!temp.isEmpty())
                myStack.push(temp.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        myStack.pop();
    }

    // Get the front element.
    public int peek() {
        return myStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return myStack.isEmpty();
    }
}