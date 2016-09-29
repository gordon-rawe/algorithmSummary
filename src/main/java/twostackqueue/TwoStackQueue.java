package twostackqueue;

import java.util.Stack;

/**
 * Created by gordon on 9/28/16.
 */
public class TwoStackQueue<T> {
    enum InnerState {
        TIN, HOUT
    }

    private InnerState state = InnerState.TIN;
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void appendTail(T element) {
        switch (state) {
            case TIN:
                stack1.push(element);
                break;
            case HOUT:
                while (stack2.size() > 0) {
                    stack1.push(stack2.pop());
                }
                stack1.push(element);
                state = InnerState.TIN;
                break;
        }
    }

    public T deleteHead() {
        switch (state) {
            case TIN:
                while (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
                state = InnerState.HOUT;
                return stack2.pop();
            case HOUT:
                return stack2.pop();
        }
        return null;
    }

    public static void main(String[] args) {
        TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        queue.appendTail(1);
        queue.appendTail(1);
        queue.appendTail(1);
        System.out.println(queue.deleteHead());
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
    }
}
