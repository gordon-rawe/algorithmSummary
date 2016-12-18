package minstack;

import java.util.Stack;

/**
 * Created by gordon on 16/12/13.
 */
public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int value) {
        stack.push(value);
        if (minStack.firstElement() > value || minStack.empty()) minStack.push(value);
        else minStack.push(minStack.firstElement());
    }

    public void pop() {
        if (stack.size() > 0 && minStack.size() > 0) {
            stack.pop();
            minStack.pop();
        }
    }

    public Integer min() {
        if (stack.empty() || minStack.empty()) return null;
        return minStack.firstElement();
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-4));
    }
}
