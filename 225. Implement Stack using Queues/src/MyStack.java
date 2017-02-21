import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sahilpujari on 10/14/16.
 */
class MyStack {
    // Push element x onto stack.
    Queue myQueue = new LinkedList();
    public void push(int x) {
        myQueue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int i = 0;
        Queue myQ = new LinkedList<>();
        Iterator it = myQueue.iterator();
        while(i++ <= myQueue.size() - 1) {
            myQ.add(myQueue.remove());
        }
        myQueue = myQ;
    }

    // Get the top element.
    public int top() {
        return (int)myQueue.remove();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return myQueue.isEmpty();
    }

    @Override
    public String toString() {
        return myQueue.toString();
    }

//    public static void main(String[] args) {
//        MyStack myStack = new MyStack();
//        myStack.push(2);
//        myStack.push(3);
//        myStack.pop();
//        System.out.println(myStack.toString());
//    }
}