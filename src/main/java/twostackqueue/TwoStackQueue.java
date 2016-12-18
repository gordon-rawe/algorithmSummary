package twostackqueue;

import java.util.Stack;

/**
 * Created by gordon on 9/28/16.
 */
public class TwoStackQueue<T> {

    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void appendTail(T element) {
        stack1.add(element);
    }

    public T deleteHead() throws Exception {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) stack2.add(stack1.pop());
        }
        if (stack2.size() <= 0) throw new Exception("queue is empty");
        return stack2.pop();
    }
}
